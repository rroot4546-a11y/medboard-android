package com.rroot.medboard

import com.rroot.medboard.data.ContentIssue
import com.rroot.medboard.data.ContentRegistry
import com.rroot.medboard.data.ContentValidator
import com.rroot.medboard.data.QnA
import com.rroot.medboard.data.Specialty
import com.rroot.medboard.data.Topic
import com.rroot.medboard.data.TopicBlock
import com.rroot.medboard.data.TopicReference
import com.rroot.medboard.data.TopicSection
import org.junit.Assert.assertTrue
import org.junit.Test

class ContentIntegrityTest {
    @Test
    fun bundledCorpusHasNoIntegrityErrors() {
        val issues = ContentValidator.validate(ContentRegistry.specialties)
            .filter { it.severity == ContentIssue.Severity.Error }
        assertTrue(
            issues.joinToString(prefix = "Content integrity errors:\n", separator = "\n") {
                "${it.topicId} [${it.location}]: ${it.message}"
            },
            issues.isEmpty(),
        )
    }

    @Test
    fun validatorDetectsPromptLeakageTruncationMarkdownAndMissingBlocks() {
        val bad = Topic(
            id = "bad-topic",
            title = "Generated topic",
            references = emptyList(),
            sections = listOf(
                TopicSection(
                    heading = "Management:",
                    blocks = listOf(
                        TopicBlock.Paragraph("As an AI language model, follow the user prompt..."),
                        TopicBlock.Bullets(emptyList()),
                        TopicBlock.Table("Broken **title", listOf("A", "B"), listOf(listOf("only one"))),
                    ),
                ),
            ),
            boardPearls = emptyList(),
            qna = listOf(QnA("Question?", "")),
        )
        val issues = ContentValidator.validate(
            listOf(Specialty("bad", "Bad", "Bad fixture", "XX", listOf(bad))),
        ).map { it.message }

        assertTrue(issues.any { "prompt" in it.lowercase() })
        assertTrue(issues.any { "truncated" in it.lowercase() })
        assertTrue(issues.any { "markdown" in it.lowercase() })
        assertTrue(issues.any { "no references" in it.lowercase() })
        assertTrue(issues.any { "list is empty" in it.lowercase() })
        assertTrue(issues.any { "cells" in it.lowercase() })
    }
}
