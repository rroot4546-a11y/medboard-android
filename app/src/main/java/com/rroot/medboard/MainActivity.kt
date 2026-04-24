package com.rroot.medboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.rroot.medboard.ui.AppNavHost
import com.rroot.medboard.ui.theme.LocalThemeController
import com.rroot.medboard.ui.theme.MedBoardTheme
import com.rroot.medboard.ui.theme.ThemeController
import com.rroot.medboard.ui.theme.ThemeMode
import com.rroot.medboard.ui.theme.ThemePreference
import com.rroot.medboard.ui.theme.next

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val ctx = LocalContext.current
            var mode by remember { mutableStateOf(ThemePreference.get(ctx)) }
            val controller = ThemeController(
                mode = mode,
                onCycle = {
                    val nextMode = mode.next()
                    mode = nextMode
                    ThemePreference.set(ctx, nextMode)
                },
            )
            MedBoardTheme(mode = mode) {
                CompositionLocalProvider(LocalThemeController provides controller) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        AppNavHost(rememberNavController())
                    }
                }
            }
        }
    }
}
