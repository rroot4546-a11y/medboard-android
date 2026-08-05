package com.rroot.medboard

import com.rroot.medboard.data.CalloutKind
import com.rroot.medboard.data.ContentRegistry
import com.rroot.medboard.data.Topic
import com.rroot.medboard.data.TopicBlock
import com.rroot.medboard.data.TopicSource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ContentRegistryTest {

    @Test
    fun specialtyIdsAreUnique() {
        val ids = ContentRegistry.specialties.map { it.id }
        assertEquals(ids.size, ids.toSet().size)
    }

    @Test
    fun topicIdsAreGloballyUnique() {
        val ids = ContentRegistry.specialties.flatMap { it.topics }.map { it.id }
        assertEquals(ids.size, ids.toSet().size)
    }

    @Test
    fun cardiologyHasAtLeastFiveReadyTopics() {
        val cardio = ContentRegistry.specialty("cardiology")
        assertNotNull(cardio)
        val ready = cardio!!.topics.count { it.sections.isNotEmpty() }
        assertTrue("Expected at least 5 cardiology topics with content, got $ready", ready >= 5)
    }

    @Test
    fun readyTopicsAllHaveReferencesPearlsAndQnA() {
        val ready = ContentRegistry.specialties.flatMap { it.topics }.filter { it.sections.isNotEmpty() }
        assertTrue("No ready topics found", ready.isNotEmpty())
        ready.forEach { t ->
            assertTrue("Topic ${t.id} has no references", t.references.isNotEmpty())
            assertTrue("Topic ${t.id} has no board pearls", t.boardPearls.isNotEmpty())
            assertTrue("Topic ${t.id} has no Q&A", t.qna.isNotEmpty())
            assertTrue("Topic ${t.id} has no sections", t.sections.isNotEmpty())
        }
    }

    @Test
    fun everyReadyTopicCitesHarrisonAndDavidson() {
        val ready = ContentRegistry.specialties.flatMap { it.topics }.filter { it.sections.isNotEmpty() }
        ready.forEach { t ->
            val hasHarrison = t.references.any { it.source.contains("Harrison", ignoreCase = true) }
            val hasDavidson = t.references.any { it.source.contains("Davidson", ignoreCase = true) }
            assertTrue("Topic ${t.id} missing Harrison citation", hasHarrison)
            assertTrue("Topic ${t.id} missing Davidson citation", hasDavidson)
        }
    }

    @Test
    fun tablesAreWellFormed() {
        val ready = ContentRegistry.specialties.flatMap { it.topics }.filter { it.sections.isNotEmpty() }
        ready.forEach { t ->
            t.sections.forEach { section ->
                section.blocks.filterIsInstance<TopicBlock.Table>().forEach { table ->
                    table.rows.forEach { row ->
                        assertEquals(
                            "Row cell count mismatches header count in topic ${t.id} / ${section.heading}",
                            table.headers.size,
                            row.size,
                        )
                    }
                }
            }
        }
    }

    @Test
    fun comingSoonSpecialtiesHaveStubTopics() {
        val cs = ContentRegistry.specialties.filter { it.comingSoon }
        cs.forEach { s ->
            assertTrue("Specialty ${s.id} comingSoon should list at least 3 stub topics", s.topics.size >= 3)
            s.topics.forEach { assertTrue("Stub topic ${it.id} unexpectedly has content", it.sections.isEmpty()) }
        }
    }

    @Test
    fun searchFindsHeartFailure() {
        val res = ContentRegistry.search("heart failure")
        assertTrue("Expected 'heart failure' to match a topic", res.any { it.title.contains("Heart Failure", ignoreCase = true) })
    }

    @Test
    fun searchIsCaseInsensitiveAndEmptySafe() {
        assertTrue(ContentRegistry.search("").isEmpty())
        assertTrue(ContentRegistry.search("ACUTE CORONARY").isNotEmpty())
    }

    @Test
    fun fullContentSearchFindsBlocksTablesPearlsQnaAndSpecialties() {
        assertTrue("Paragraph/bullet text should be searchable", ContentRegistry.search("papillary muscle rupture").isNotEmpty())
        assertTrue("Table cells should be searchable", ContentRegistry.search("Aortic valve area").isNotEmpty())
        assertTrue("Board pearls should be searchable", ContentRegistry.search("tearing maximal-at-onset").isNotEmpty())
        assertTrue("Q&A answers should be searchable", ContentRegistry.search("monitor potassium").isNotEmpty())
        assertTrue("Specialty names should be searchable", ContentRegistry.search("neurology").isNotEmpty())
    }

    @Test
    fun multiTokenSearchCanMatchAcrossFieldsAndReturnsContext() {
        val results = ContentRegistry.searchDetailed("heart transplantation")
        assertTrue(results.isNotEmpty())
        assertTrue(results.first().matchedIn.isNotBlank())
        assertTrue(results.first().snippet.isNotBlank())
    }

    @Test
    fun everyReadyTopicHasAtLeastOneSourceAttributedBlock() {
        val ready = ContentRegistry.specialties.flatMap { it.topics }.filter { it.sections.isNotEmpty() }
        ready.forEach { t ->
            val attributed = t.sections.flatMap { it.blocks }.any { it.source != null }
            assertTrue("Topic ${t.id} has no source-attributed block", attributed)
        }
    }

    @Test
    fun allThreeSourcesAreUsedAcrossCorpus() {
        val sources = ContentRegistry.specialties.flatMap { it.topics }
            .flatMap { it.sections }.flatMap { it.blocks }
            .mapNotNull { it.source }.toSet()
        assertTrue("Harrison-only attribution used", sources.contains(TopicSource.Harrison))
        assertTrue("Davidson-only attribution used", sources.contains(TopicSource.Davidson))
        assertTrue("Both-sources attribution used", sources.contains(TopicSource.Both))
    }

    @Test
    fun majorSpecialtiesHaveReadyTopics() {
        val expectedReadySpecialties = listOf(
            "cardiology",
            "pulmonology",
            "nephrology",
            "endocrinology",
            "gastroenterology",
            "infectious",
            "neurology",
        )
        expectedReadySpecialties.forEach { id ->
            val s = ContentRegistry.specialty(id)
            assertNotNull("Specialty $id missing", s)
            val ready = s!!.topics.count { it.sections.isNotEmpty() }
            assertTrue("Specialty $id should have at least one ready topic", ready >= 1)
        }
    }

    @Test
    fun calloutKindsAreUsed() {
        val callouts = ContentRegistry.specialties.flatMap { it.topics }
            .flatMap { it.sections }
            .flatMap { it.blocks }
            .filterIsInstance<TopicBlock.Callout>()
        assertTrue("Expected at least one callout in the content", callouts.isNotEmpty())
        val kinds = callouts.map { it.kind }.toSet()
        // at minimum we use an Exam tip, a Warning and a Pitfall somewhere
        assertTrue(kinds.contains(CalloutKind.Exam) || kinds.contains(CalloutKind.Pearl))
    }
}
