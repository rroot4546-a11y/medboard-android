package com.rroot.medboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rroot.medboard.data.CalloutKind
import com.rroot.medboard.data.ContentRegistry
import com.rroot.medboard.data.QnA
import com.rroot.medboard.data.Topic
import com.rroot.medboard.data.TopicBlock
import com.rroot.medboard.data.TopicReference
import com.rroot.medboard.data.TopicSection
import com.rroot.medboard.data.TopicSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicScreen(topicId: String, onBack: () -> Unit) {
    val topic = ContentRegistry.topic(topicId)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            topic?.title ?: "Topic",
                            fontWeight = FontWeight.SemiBold,
                        )
                        if (!topic?.subtitle.isNullOrBlank()) {
                            Text(
                                topic!!.subtitle,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { inner ->
        if (topic == null) {
            Column(Modifier.padding(inner).padding(16.dp)) { Text("Topic not found.") }
            return@Scaffold
        }
        if (topic.sections.isEmpty()) {
            ComingSoonBody(topic, Modifier.padding(inner))
            return@Scaffold
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                horizontal = 16.dp, vertical = 8.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            if (topic.references.isNotEmpty()) {
                item { ReferencesCard(topic.references) }
            }
            items(count = topic.sections.size) { i ->
                SectionBlock(topic.sections[i])
            }
            if (topic.boardPearls.isNotEmpty()) {
                item { BoardPearlsCard(topic.boardPearls) }
            }
            if (topic.qna.isNotEmpty()) {
                item { RapidQnACard(topic.qna) }
            }
        }
    }
}

@Composable
private fun ComingSoonBody(topic: Topic, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(topic.title, style = MaterialTheme.typography.headlineMedium)
        if (topic.subtitle.isNotBlank()) {
            Text(
                topic.subtitle,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        Spacer(Modifier.height(8.dp))
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.12f),
            ),
        ) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Coming soon", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.tertiary)
                Text(
                    "This topic hasn\u2019t been written yet. The planned scope is shown here so you can see what\u2019s on the roadmap. " +
                        "Cardiology is the first specialty with content; the rest will be added specialty-by-specialty in subsequent updates.",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@Composable
private fun ReferencesCard(references: List<TopicReference>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Bookmark, null, tint = MaterialTheme.colorScheme.onSecondaryContainer)
                Spacer(Modifier.width(8.dp))
                Text(
                    "Source texts studied",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                )
            }
            references.forEach { r ->
                Text(
                    "\u2022 ${r.source} \u2014 ${r.citation}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                )
            }
            Text(
                "Summary below is written in the authors\u2019 own words; no textbook content is reproduced.",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
            )
        }
    }
}

@Composable
private fun SectionBlock(section: TopicSection) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(
            section.heading,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
        )
        HorizontalDivider(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.25f))
        section.blocks.forEach { block ->
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                when (block) {
                    is TopicBlock.Paragraph -> Text(block.text, style = MaterialTheme.typography.bodyLarge)
                    is TopicBlock.SubHeading -> Text(
                        block.text,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                    is TopicBlock.Bullets -> BulletList(block.items, ordered = false)
                    is TopicBlock.Numbered -> BulletList(block.items, ordered = true)
                    is TopicBlock.Table -> MedTable(block)
                    is TopicBlock.Callout -> CalloutBox(block.kind, block.text)
                }
                block.source?.let { SourceAttribution(it) }
            }
        }
    }
}

@Composable
private fun SourceAttribution(source: TopicSource) {
    val bg = when (source) {
        TopicSource.Harrison -> MaterialTheme.colorScheme.secondary.copy(alpha = 0.12f)
        TopicSource.Davidson -> MaterialTheme.colorScheme.tertiary.copy(alpha = 0.14f)
        TopicSource.Both -> MaterialTheme.colorScheme.primary.copy(alpha = 0.10f)
    }
    val tint = when (source) {
        TopicSource.Harrison -> MaterialTheme.colorScheme.secondary
        TopicSource.Davidson -> MaterialTheme.colorScheme.tertiary
        TopicSource.Both -> MaterialTheme.colorScheme.primary
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(999.dp))
                .background(bg)
                .padding(horizontal = 8.dp, vertical = 3.dp),
        ) {
            Text(
                "\u2014 " + source.label(),
                style = MaterialTheme.typography.labelSmall,
                color = tint,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

@Composable
private fun BulletList(items: List<String>, ordered: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items.forEachIndexed { idx, text ->
            Row(verticalAlignment = Alignment.Top) {
                val marker = if (ordered) "${idx + 1}." else "\u2022"
                Text(
                    marker,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.width(24.dp),
                    color = MaterialTheme.colorScheme.primary,
                )
                Text(text, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun MedTable(t: TopicBlock.Table) {
    val columnMinWidth = 140.dp
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
    ) {
        Column(Modifier.padding(vertical = 8.dp)) {
            if (!t.title.isNullOrBlank()) {
                Text(
                    t.title,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                )
            }
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 12.dp),
            ) {
                Column {
                    // Header row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primaryContainer),
                    ) {
                        t.headers.forEach { h ->
                            Text(
                                h,
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier
                                    .width(columnMinWidth)
                                    .padding(8.dp),
                            )
                        }
                    }
                    // Rows
                    t.rows.forEachIndexed { idx, row ->
                        val bg = if (idx % 2 == 0) MaterialTheme.colorScheme.surface
                        else MaterialTheme.colorScheme.surfaceVariant
                        Row(modifier = Modifier.background(bg).fillMaxWidth()) {
                            row.forEach { cell ->
                                Text(
                                    cell,
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier
                                        .width(columnMinWidth)
                                        .padding(8.dp),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

private data class CalloutStyle(val icon: ImageVector, val tint: Color, val bg: Color, val label: String)

@Composable
private fun CalloutBox(kind: CalloutKind, text: String) {
    val s = when (kind) {
        CalloutKind.Pearl -> CalloutStyle(
            Icons.Default.Lightbulb,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.primary.copy(alpha = 0.10f),
            "Pearl",
        )
        CalloutKind.Warning -> CalloutStyle(
            Icons.Default.WarningAmber,
            MaterialTheme.colorScheme.error,
            MaterialTheme.colorScheme.error.copy(alpha = 0.10f),
            "Warning",
        )
        CalloutKind.Pitfall -> CalloutStyle(
            Icons.Default.ErrorOutline,
            MaterialTheme.colorScheme.tertiary,
            MaterialTheme.colorScheme.tertiary.copy(alpha = 0.12f),
            "Pitfall",
        )
        CalloutKind.Exam -> CalloutStyle(
            Icons.Default.CheckCircle,
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.secondary.copy(alpha = 0.12f),
            "Exam tip",
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(s.bg)
            .padding(14.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(s.icon, null, tint = s.tint)
                Spacer(Modifier.width(8.dp))
                Text(
                    s.label,
                    style = MaterialTheme.typography.labelLarge,
                    color = s.tint,
                    fontWeight = FontWeight.Bold,
                )
            }
            Text(text, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
private fun BoardPearlsCard(pearls: List<String>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
    ) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Lightbulb, null, tint = MaterialTheme.colorScheme.onPrimaryContainer)
                Spacer(Modifier.width(8.dp))
                Text(
                    "Board pearls",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            }
            pearls.forEach { p ->
                Row(verticalAlignment = Alignment.Top) {
                    Text(
                        "\u2022",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.width(16.dp),
                    )
                    Text(
                        p,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        }
    }
}

@Composable
private fun RapidQnACard(qna: List<QnA>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    ) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text("Rapid Q\u0026A", style = MaterialTheme.typography.titleLarge)
            qna.forEachIndexed { idx, q ->
                QnARow(q, idx + 1)
                if (idx != qna.lastIndex) HorizontalDivider()
            }
        }
    }
}

@Composable
private fun QnARow(q: QnA, number: Int) {
    var shown by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                if (shown) MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
                else MaterialTheme.colorScheme.surfaceVariant,
            )
            .clickable { shown = !shown }
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Text(
            "Q$number. ${q.question}",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
        )
        Text(
            text = if (shown) "A. ${q.answer}" else "Tap to reveal answer",
            style = MaterialTheme.typography.bodyMedium,
            color = if (shown) MaterialTheme.colorScheme.onSurface
            else MaterialTheme.colorScheme.primary,
        )
    }
}


