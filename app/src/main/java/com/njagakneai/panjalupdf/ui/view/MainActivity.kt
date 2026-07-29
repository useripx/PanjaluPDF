package com.njagakneai.panjalupdf.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.njagakneai.panjalupdf.ui.navigation.AppNavigation
import com.njagakneai.panjalupdf.ui.theme.PanjaluPDFTheme
import com.njagakneai.panjalupdf.data.preferences.PreferencesManager
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.isSystemInDarkTheme
import javax.inject.Inject
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appTheme by preferencesManager.appTheme.collectAsState(initial = "Sistem")
            val isDarkTheme = when (appTheme) {
                "Terang" -> false
                "Gelap" -> true
                else -> isSystemInDarkTheme()
            }

            PanjaluPDFTheme(darkTheme = isDarkTheme) {
                AppNavigation()
            }
        }
    }
}
