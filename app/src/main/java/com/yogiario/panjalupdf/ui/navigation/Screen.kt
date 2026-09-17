package com.yogiario.panjalupdf.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object CameraScan : Screen("camera_scan")
    object Convert : Screen("convert")
    object EditFoto : Screen("edit_foto")
    object MyDocuments : Screen("my_documents")
    object Settings : Screen("settings")
}
