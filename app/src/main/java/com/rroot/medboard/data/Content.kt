package com.rroot.medboard.data

/**
 * Content model for the MedBoard study app.
 *
 * IMPORTANT ORIGINAL-CONTENT POLICY:
 * Every [Topic] in this app is written in the authors' own words as an
 * original concise revision summary. Harrison's Principles of Internal
 * Medicine (21st ed.) and Davidson's Principles and Practice of Medicine
 * (24th ed.) are cited as the source texts that were studied, but no
 * text, table, figure, or any other copyrighted content from those
 * books has been copied into this app. Contributors MUST follow the
 * same policy for any new topic: do not paste from the textbooks.
 */

/** A top-level specialty (Cardiology, Pulmonology, etc.). */
data class Specialty(
    val id: String,
    val name: String,
    val blurb: String,
    /** Short 1-2 letter code shown in the specialty grid tile. */
    val code: String,
    /** Topics, in the order they should appear in the list. */
    val topics: List<Topic>,
    /** True until the specialty has at least one [Topic] with real content. */
    val comingSoon: Boolean = topics.all { it.sections.isEmpty() },
)

data class Topic(
    val id: String,
    val title: String,
    val subtitle: String = "",
    val references: List<TopicReference> = emptyList(),
    val sections: List<TopicSection> = emptyList(),
    val boardPearls: List<String> = emptyList(),
    val qna: List<QnA> = emptyList(),
)

data class TopicReference(
    /** e.g. "Harrison 21e", "Davidson 24e". */
    val source: String,
    /** e.g. "Ch. 268 \u2014 Acute coronary syndromes". */
    val citation: String,
)

data class TopicSection(
    val heading: String,
    val blocks: List<TopicBlock>,
)

sealed class TopicBlock {
    data class Paragraph(val text: String) : TopicBlock()
    data class Bullets(val items: List<String>) : TopicBlock()
    data class Numbered(val items: List<String>) : TopicBlock()
    data class Table(
        val title: String?,
        val headers: List<String>,
        val rows: List<List<String>>,
    ) : TopicBlock()
    data class Callout(val kind: CalloutKind, val text: String) : TopicBlock()
    data class SubHeading(val text: String) : TopicBlock()
}

enum class CalloutKind { Pearl, Warning, Pitfall, Exam }

data class QnA(val question: String, val answer: String)
