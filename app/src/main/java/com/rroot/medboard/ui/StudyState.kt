package com.rroot.medboard.ui

import androidx.compose.runtime.compositionLocalOf
import com.rroot.medboard.data.StudyRepository
import com.rroot.medboard.data.StudyState

val LocalStudyRepository = compositionLocalOf<StudyRepository> {
    error("StudyRepository not provided")
}

val LocalStudyState = compositionLocalOf { StudyState() }
