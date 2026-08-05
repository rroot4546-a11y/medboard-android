package com.rroot.medboard.data

/** Severity-tagged content quality issue suitable for unit tests and editor tooling. */
data class ContentIssue(
    val topicId: String,
    val location: String,
    val message: String,
    val severity: Severity = Severity.Error,
) {
    enum class Severity { Error, Warning }
}

/** Deterministic checks that prevent malformed or accidentally generated content entering a build. */
object ContentValidator {
    private val promptLeakage = Regex(
        "(?i)(as an ai|language model|user prompt|system prompt|instructions above|generate (?:a|the) topic|placeholder text|lorem ipsum|chatgpt)",
    )
    private val unfinished = Regex("(?i)(\\b(?:todo|tbd|fixme)\\b|(?:continued|to be continued)\\s*$|\\.\\.\\.\\s*$|[:;,-]\\s*$)")
    private val markdownHeading = Regex("(?m)^\\s*#{1,6}(?:\\s*$|\\s+)")
    private val extremeWhitespace = Regex("[ \\t]{4,}|\\n{3,}")

    fun validate(specialties: List<Specialty>): List<ContentIssue> = buildList {
        val specialtyIds = specialties.groupingBy { it.id }.eachCount().filterValues { it > 1 }
        specialtyIds.keys.forEach { add(ContentIssue("<registry>", "specialty", "Duplicate specialty id: $it")) }
        val topics = specialties.flatMap { specialty -> specialty.topics.map { specialty to it } }
        topics.groupingBy { it.second.id }.eachCount().filterValues { it > 1 }.keys.forEach {
            add(ContentIssue(it, "registry", "Duplicate topic id"))
        }
        topics.forEach { (specialty, topic) -> validateTopic(specialty, topic, this) }
    }

    private fun validateTopic(specialty: Specialty, topic: Topic, issues: MutableList<ContentIssue>) {
        checkText(topic, "title", topic.title, issues)
        if (topic.title.isBlank()) issues += ContentIssue(topic.id, "title", "Topic title is blank")
        if (topic.sections.isEmpty()) return // Deliberate roadmap stub.

        if (topic.references.isEmpty()) issues += ContentIssue(topic.id, "references", "Ready topic has no references")
        if (topic.boardPearls.isEmpty()) issues += ContentIssue(topic.id, "board pearls", "Ready topic has no board pearls")
        if (topic.qna.isEmpty()) issues += ContentIssue(topic.id, "rapid Q&A", "Ready topic has no rapid Q&A")
        if (specialty.name.isBlank()) issues += ContentIssue(topic.id, "specialty", "Specialty name is blank")

        topic.references.forEachIndexed { index, reference ->
            checkText(topic, "reference ${index + 1}", "${reference.source} ${reference.citation}", issues)
            if (reference.source.isBlank() || reference.citation.isBlank()) {
                issues += ContentIssue(topic.id, "reference ${index + 1}", "Reference source/citation is incomplete")
            }
        }
        topic.sections.forEachIndexed { sectionIndex, section ->
            val location = "section ${sectionIndex + 1}"
            checkText(topic, "$location heading", section.heading, issues)
            if (section.heading.isBlank()) issues += ContentIssue(topic.id, location, "Section heading is blank")
            if (section.blocks.isEmpty()) issues += ContentIssue(topic.id, location, "Section contains no blocks")
            section.blocks.forEachIndexed { blockIndex, block ->
                validateBlock(topic, block, "$location block ${blockIndex + 1}", issues)
            }
        }
        topic.boardPearls.forEachIndexed { index, text -> checkText(topic, "board pearl ${index + 1}", text, issues) }
        topic.qna.forEachIndexed { index, qna ->
            checkText(topic, "question ${index + 1}", qna.question, issues)
            checkText(topic, "answer ${index + 1}", qna.answer, issues)
            if (qna.question.isBlank() || qna.answer.isBlank()) issues += ContentIssue(topic.id, "Q&A ${index + 1}", "Question or answer is blank")
        }
    }

    private fun validateBlock(topic: Topic, block: TopicBlock, location: String, issues: MutableList<ContentIssue>) {
        when (block) {
            is TopicBlock.Paragraph -> checkText(topic, location, block.text, issues)
            is TopicBlock.Bullets -> validateItems(topic, location, block.items, issues)
            is TopicBlock.Numbered -> validateItems(topic, location, block.items, issues)
            is TopicBlock.Callout -> checkText(topic, location, block.text, issues)
            is TopicBlock.SubHeading -> checkText(topic, "$location subheading", block.text, issues)
            is TopicBlock.Table -> {
                block.title?.let { checkText(topic, "$location title", it, issues) }
                if (block.headers.isEmpty()) issues += ContentIssue(topic.id, location, "Table has no headers")
                if (block.rows.isEmpty()) issues += ContentIssue(topic.id, location, "Table has no rows")
                block.headers.forEachIndexed { i, text -> checkText(topic, "$location header ${i + 1}", text, issues) }
                block.rows.forEachIndexed { rowIndex, row ->
                    if (row.size != block.headers.size) issues += ContentIssue(topic.id, "$location row ${rowIndex + 1}", "Table has ${row.size} cells but ${block.headers.size} headers")
                    row.forEachIndexed { cellIndex, text -> checkText(topic, "$location cell ${rowIndex + 1}.${cellIndex + 1}", text, issues) }
                }
            }
        }
    }

    private fun validateItems(topic: Topic, location: String, items: List<String>, issues: MutableList<ContentIssue>) {
        if (items.isEmpty()) issues += ContentIssue(topic.id, location, "List is empty")
        items.forEachIndexed { index, text -> checkText(topic, "$location item ${index + 1}", text, issues) }
    }

    private fun checkText(topic: Topic, location: String, text: String, issues: MutableList<ContentIssue>) {
        if (text.isBlank()) {
            issues += ContentIssue(topic.id, location, "Text is blank")
            return
        }
        if (promptLeakage.containsMatchIn(text)) issues += ContentIssue(topic.id, location, "Possible prompt/placeholder leakage")
        if (markdownHeading.containsMatchIn(text)) issues += ContentIssue(topic.id, location, "Raw or unfinished Markdown heading")
        if (extremeWhitespace.containsMatchIn(text)) issues += ContentIssue(topic.id, location, "Extreme whitespace")
        if (hasUnbalancedMarkdown(text)) issues += ContentIssue(topic.id, location, "Unbalanced Markdown delimiter")
        if (unfinished.containsMatchIn(text.trim())) issues += ContentIssue(topic.id, location, "Text appears truncated or unfinished")
    }

    private fun hasUnbalancedMarkdown(text: String): Boolean {
        val backticks = text.count { it == '`' }
        val boldMarkers = Regex("\\*\\*").findAll(text).count()
        return backticks % 2 != 0 || boldMarkers % 2 != 0
    }
}
