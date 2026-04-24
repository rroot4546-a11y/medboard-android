package com.rroot.medboard.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

private val LightColors = lightColorScheme(
    primary = Color(0xFF0E7C86),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFB5ECEE),
    onPrimaryContainer = Color(0xFF002022),
    secondary = Color(0xFF3949AB),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFDDE1FF),
    onSecondaryContainer = Color(0xFF000F5C),
    tertiary = Color(0xFFB35900),
    onTertiary = Color.White,
    error = Color(0xFFBA1A1A),
    background = Color(0xFFF6F8FA),
    onBackground = Color(0xFF101417),
    surface = Color.White,
    onSurface = Color(0xFF101417),
    surfaceVariant = Color(0xFFE3EBEF),
    onSurfaceVariant = Color(0xFF3F4B54),
    outline = Color(0xFF6F7A85),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF4FD8E2),
    onPrimary = Color(0xFF003438),
    primaryContainer = Color(0xFF005157),
    onPrimaryContainer = Color(0xFFB5ECEE),
    secondary = Color(0xFFB9C4FF),
    onSecondary = Color(0xFF0A1F6B),
    secondaryContainer = Color(0xFF1E3088),
    onSecondaryContainer = Color(0xFFDDE1FF),
    tertiary = Color(0xFFFFB787),
    onTertiary = Color(0xFF4A2600),
    error = Color(0xFFFFB4AB),
    background = Color(0xFF0E1115),
    onBackground = Color(0xFFE3E7EB),
    surface = Color(0xFF131821),
    onSurface = Color(0xFFE3E7EB),
    surfaceVariant = Color(0xFF232C34),
    onSurfaceVariant = Color(0xFFC1CCD6),
    outline = Color(0xFF8B95A0),
)

private val AppTypography = Typography(
    displayLarge = TextStyle(fontSize = 34.sp, fontWeight = FontWeight.SemiBold),
    displayMedium = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.SemiBold),
    headlineLarge = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold),
    headlineMedium = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold),
    headlineSmall = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
    titleLarge = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
    titleMedium = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium),
    titleSmall = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
    bodyLarge = TextStyle(fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium = TextStyle(fontSize = 14.sp, lineHeight = 21.sp),
    bodySmall = TextStyle(fontSize = 12.sp, lineHeight = 18.sp),
    labelLarge = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
    labelMedium = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
    labelSmall = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Medium),
)

data class ThemeController(
    val mode: ThemeMode,
    val onCycle: () -> Unit,
)

val LocalThemeController = compositionLocalOf<ThemeController> {
    error("ThemeController not provided")
}

@Composable
fun MedBoardTheme(
    mode: ThemeMode,
    content: @Composable () -> Unit,
) {
    val systemDark = isSystemInDarkTheme()
    val darkTheme = when (mode) {
        ThemeMode.System -> systemDark
        ThemeMode.Light -> false
        ThemeMode.Dark -> true
    }
    val colors = if (darkTheme) DarkColors else LightColors
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }
    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content,
    )
}
