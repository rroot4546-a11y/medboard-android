package com.rroot.medboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.rroot.medboard.ui.AppNavHost
import com.rroot.medboard.ui.theme.MedBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MedBoardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavHost(rememberNavController())
                }
            }
        }
    }
}
