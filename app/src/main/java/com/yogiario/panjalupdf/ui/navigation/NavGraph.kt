package com.yogiario.panjalupdf.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yogiario.panjalupdf.ui.home.HomeScreen
import com.yogiario.panjalupdf.ui.splash.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onTimeout = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.Home.route) {
            HomeScreen()
        }
        
        // TODO: M2/M3 akan menambahkan layar-layar lainnya (Camera, Convert, dll)
    }
}
