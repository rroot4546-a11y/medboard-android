package com.rroot.medboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.BrightnessAuto
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rroot.medboard.data.ContentRegistry
import com.rroot.medboard.data.Specialty
import com.rroot.medboard.data.Topic
import com.rroot.medboard.ui.theme.LocalThemeController
import com.rroot.medboard.ui.theme.ThemeMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onSpecialty: (String) -> Unit,
    onTopic: (String) -> Unit,
    onSearch: () -> Unit,
    onDisclaimer: () -> Unit,
) {
    val studyState = LocalStudyState.current
    val recentTopics = studyState.recentTopicIds.mapNotNull(ContentRegistry::topic).take(3)
    val bookmarked = studyState.bookmarkedTopicIds.mapNotNull(ContentRegistry::topic)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("MedBoard", fontWeight = FontWeight.SemiBold)
                        Text("Internal medicine · focused revision", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                actions = {
                    val controller = LocalThemeController.current
                    IconButton(onClick = controller.onCycle) {
                        val icon = when (controller.mode) {
                            ThemeMode.System -> Icons.Default.BrightnessAuto
                            ThemeMode.Light -> Icons.Default.LightMode
                            ThemeMode.Dark -> Icons.Default.DarkMode
                        }
                        Icon(icon, "Theme: ${controller.mode.name}")
                    }
                    IconButton(onClick = onSearch) { Icon(Icons.Default.Search, "Search") }
                    IconButton(onClick = onDisclaimer) { Icon(Icons.Default.Info, "About") }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { inner ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 168.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize().padding(inner),
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) { HeroBanner(studyState.bookmarkedTopicIds.size) }
            if (recentTopics.isNotEmpty()) {
                item(span = { GridItemSpan(maxLineSpan) }) { SectionTitle("Continue studying", "Your recently opened topics") }
                items(recentTopics, key = { "recent-${it.id}" }, span = { GridItemSpan(maxLineSpan) }) { topic ->
                    ContinueCard(topic, topic.id in studyState.bookmarkedTopicIds) { onTopic(topic.id) }
                }
            } else if (bookmarked.isNotEmpty()) {
                item(span = { GridItemSpan(maxLineSpan) }) { SectionTitle("Saved for later", "Your bookmarked topics") }
                items(bookmarked.take(3), key = { "saved-${it.id}" }, span = { GridItemSpan(maxLineSpan) }) { topic ->
                    ContinueCard(topic, true) { onTopic(topic.id) }
                }
            }
            item(span = { GridItemSpan(maxLineSpan) }) { SectionTitle("Specialties", "Browse the complete study map") }
            items(ContentRegistry.specialties, key = { it.id }) { specialty ->
                SpecialtyTile(specialty) { onSpecialty(specialty.id) }
            }
        }
    }
}

@Composable
private fun HeroBanner(bookmarkCount: Int) {
    val all = ContentRegistry.specialties.flatMap { it.topics }
    val ready = all.count { it.sections.isNotEmpty() }
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        shape = RoundedCornerShape(24.dp),
    ) {
        Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Build clinical recall, one topic at a time", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onPrimaryContainer)
            Text("Original structured summaries with tables, safety callouts, board pearls and rapid Q&A.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onPrimaryContainer)
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Metric("$ready", "ready", Modifier.weight(1f))
                Metric("${all.size}", "planned", Modifier.weight(1f))
                Metric("$bookmarkCount", "saved", Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun Metric(value: String, label: String, modifier: Modifier = Modifier) {
    Box(modifier.clip(RoundedCornerShape(14.dp)).background(MaterialTheme.colorScheme.surface.copy(alpha = 0.72f)).padding(10.dp)) {
        Column { Text(value, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary); Text(label, style = MaterialTheme.typography.labelSmall) }
    }
}

@Composable
private fun SectionTitle(title: String, subtitle: String) {
    Column(Modifier.padding(top = 8.dp)) {
        Text(title, style = MaterialTheme.typography.titleLarge)
        Text(subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
private fun ContinueCard(topic: Topic, bookmarked: Boolean, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick), shape = RoundedCornerShape(18.dp), elevation = CardDefaults.cardElevation(1.dp)) {
        Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Text(if (bookmarked) "BOOKMARKED · CONTINUE" else "CONTINUE", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                Text(topic.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                Text("${topic.sections.size} sections · ${topic.boardPearls.size} pearls", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, null)
        }
    }
}

@Composable
private fun SpecialtyTile(specialty: Specialty, onClick: () -> Unit) {
    val ready = specialty.topics.count { it.sections.isNotEmpty() }
    Card(
        modifier = Modifier.fillMaxWidth().height(168.dp).clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = if (ready > 0) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = if (ready > 0) 1.dp else 0.dp),
    ) {
        Column(Modifier.fillMaxSize().padding(15.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.size(40.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primary), contentAlignment = Alignment.Center) {
                    Text(specialty.code, color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.width(10.dp))
                Text(specialty.name, modifier = Modifier.weight(1f), style = MaterialTheme.typography.titleMedium, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(specialty.blurb, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 2, overflow = TextOverflow.Ellipsis)
                Text(if (ready == 0) "Planned · ${specialty.topics.size} topics" else "$ready of ${specialty.topics.size} ready", style = MaterialTheme.typography.labelSmall, color = if (ready == 0) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary)
            }
        }
    }
}
