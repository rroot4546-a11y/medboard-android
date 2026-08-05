package com.rroot.medboard.data

import java.text.Normalizer
import java.util.Locale

/** A ranked, explainable match returned by the full-content search index. */
data class TopicSearchResult(
    val topic: Topic,
    val specialty: Specialty,
    val matchedIn: String,
    val snippet: String,
    val score: Int,
)

/**
 * In-memory search over the bundled corpus. The content set is static and small enough that this
 * avoids a database/FTS dependency while still searching every user-visible field.
 */
object TopicSearch {
    private data class Field(val label: String, val text: String, val weight: Int)

    fun search(specialties: List<Specialty>, rawQuery: String): List<TopicSearchResult> {
        val query = normalise(rawQuery.trim())
        val tokens = query.split(' ').filter { it.length > 1 }.distinct()
        if (query.isBlank() || tokens.isEmpty()) return emptyList()

        return specialties.asSequence()
            .flatMap { specialty -> specialty.topics.asSequence().map { specialty to it } }
            .mapNotNull { (specialty, topic) -> match(specialty, topic, query, tokens) }
            .sortedWith(
                compareByDescending<TopicSearchResult> { it.score }
                    .thenByDescending { it.topic.sections.isNotEmpty() }
                    .thenBy { it.topic.title },
            )
            .toList()
    }

    private fun match(
        specialty: Specialty,
        topic: Topic,
        query: String,
        tokens: List<String>,
    ): TopicSearchResult? {
        val fields = fields(specialty, topic)
        val normalisedFields = fields.map { it to normalise(it.text) }
        val wholeDocument = normalisedFields.joinToString(" ") { it.second }
        if (tokens.any { it !in wholeDocument }) return null

        var score = 0
        var bestField: Field? = null
        var bestFieldScore = Int.MIN_VALUE
        normalisedFields.forEach { (field, text) ->
            val phraseHit = query in text
            val tokenHits = tokens.count { it in text }
            if (phraseHit || tokenHits > 0) {
                val fieldScore = (tokenHits * field.weight) + if (phraseHit) field.weight * 4 else 0
                score += fieldScore
                if (fieldScore > bestFieldScore) {
                    bestFieldScore = fieldScore
                    bestField = field
                }
            }
        }
        if (topic.sections.isNotEmpty()) score += 2
        val chosen = bestField ?: return null
        return TopicSearchResult(
            topic = topic,
            specialty = specialty,
            matchedIn = chosen.label,
            snippet = snippet(chosen.text, tokens),
            score = score,
        )
    }

    private fun fields(specialty: Specialty, topic: Topic): List<Field> = buildList {
        add(Field("Title", topic.title, 14))
        add(Field("Subtitle", topic.subtitle, 10))
        add(Field("Specialty", "${specialty.name} ${specialty.blurb} ${specialty.code}", 9))
        topic.sections.forEach { section ->
            add(Field("Section", section.heading, 8))
            section.blocks.forEach { block ->
                when (block) {
                    is TopicBlock.Paragraph -> add(Field(section.heading, block.text, 4))
                    is TopicBlock.Bullets -> block.items.forEach { add(Field(section.heading, it, 4)) }
                    is TopicBlock.Numbered -> block.items.forEach { add(Field(section.heading, it, 4)) }
                    is TopicBlock.Table -> {
                        block.title?.let { add(Field("Table", it, 7)) }
                        block.headers.forEach { add(Field("Table heading", it, 6)) }
                        block.rows.flatten().forEach { add(Field("Table", it, 5)) }
                    }
                    is TopicBlock.Callout -> add(Field("${block.kind.name} callout", block.text, 7))
                    is TopicBlock.SubHeading -> add(Field("Subheading", block.text, 8))
                }
            }
        }
        topic.boardPearls.forEach { add(Field("Board pearl", it, 8)) }
        topic.qna.forEach {
            add(Field("Rapid Q&A", it.question, 8))
            add(Field("Rapid Q&A", it.answer, 7))
        }
    }.filter { it.text.isNotBlank() }

    private fun snippet(text: String, tokens: List<String>, maxLength: Int = 170): String {
        val compact = text.replace(Regex("\\s+"), " ").trim()
        if (compact.length <= maxLength) return compact
        val normalised = normalise(compact)
        val hit = tokens.map { normalised.indexOf(it) }.filter { it >= 0 }.minOrNull() ?: 0
        val start = (hit - maxLength / 3).coerceAtLeast(0).coerceAtMost(compact.length - maxLength)
        val end = (start + maxLength).coerceAtMost(compact.length)
        return buildString {
            if (start > 0) append("…")
            append(compact.substring(start, end).trim())
            if (end < compact.length) append("…")
        }
    }

    internal fun normalise(value: String): String = Normalizer
        .normalize(value.lowercase(Locale.ROOT), Normalizer.Form.NFD)
        .replace(Regex("\\p{M}+"), "")
        .replace(Regex("[^a-z0-9]+"), " ")
        .trim()
}
