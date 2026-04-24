package com.rroot.medboard.ui.theme

import android.content.Context

enum class ThemeMode { System, Light, Dark }

object ThemePreference {
    private const val PREFS = "medboard_prefs"
    private const val KEY = "theme_mode"

    fun get(context: Context): ThemeMode {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val raw = prefs.getString(KEY, ThemeMode.System.name) ?: ThemeMode.System.name
        return runCatching { ThemeMode.valueOf(raw) }.getOrDefault(ThemeMode.System)
    }

    fun set(context: Context, mode: ThemeMode) {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY, mode.name).apply()
    }
}

/** Cycle System \u2192 Light \u2192 Dark \u2192 System. */
fun ThemeMode.next(): ThemeMode = when (this) {
    ThemeMode.System -> ThemeMode.Light
    ThemeMode.Light -> ThemeMode.Dark
    ThemeMode.Dark -> ThemeMode.System
}
