package com.rroot.medboard.data

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.studyDataStore by preferencesDataStore(name = "study_progress")

/** Persisted, intentionally small study state. */
data class StudyState(
    val bookmarkedTopicIds: Set<String> = emptySet(),
    val recentTopicIds: List<String> = emptyList(),
    val lastOpenedAtMillis: Long = 0L,
)

class StudyRepository(private val context: Context) {
    val state: Flow<StudyState> = context.studyDataStore.data.map { preferences ->
        StudyState(
            bookmarkedTopicIds = decode(preferences[BOOKMARKS]).toSet(),
            recentTopicIds = decode(preferences[RECENTS]),
            lastOpenedAtMillis = preferences[LAST_OPENED] ?: 0L,
        )
    }

    suspend fun toggleBookmark(topicId: String) {
        context.studyDataStore.edit { preferences ->
            val current = decode(preferences[BOOKMARKS]).toMutableSet()
            if (!current.add(topicId)) current.remove(topicId)
            preferences[BOOKMARKS] = encode(current.sorted())
        }
    }

    suspend fun recordOpened(topicId: String) {
        context.studyDataStore.edit { preferences ->
            val recents = decode(preferences[RECENTS]).filterNot { it == topicId }
            preferences[RECENTS] = encode((listOf(topicId) + recents).take(MAX_RECENTS))
            preferences[LAST_OPENED] = System.currentTimeMillis()
        }
    }

    private companion object {
        const val MAX_RECENTS = 8
        val BOOKMARKS: Preferences.Key<String> = stringPreferencesKey("bookmarks")
        val RECENTS: Preferences.Key<String> = stringPreferencesKey("recents")
        val LAST_OPENED: Preferences.Key<Long> = longPreferencesKey("last_opened")

        fun decode(value: String?): List<String> = value.orEmpty()
            .split('|')
            .map(String::trim)
            .filter(String::isNotEmpty)
            .distinct()

        fun encode(ids: Collection<String>): String = ids.joinToString("|")
    }
}
