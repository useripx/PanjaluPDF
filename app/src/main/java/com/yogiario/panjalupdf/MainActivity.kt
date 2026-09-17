package com.yogiario.panjalupdf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yogiario.panjalupdf.ui.navigation.NavGraph
import com.yogiario.panjalupdf.ui.theme.PanjaluPDFTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PanjaluPDFTheme {
                NavGraph()
            }
        }
    }
}