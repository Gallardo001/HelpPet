package ex.gallardo.helppet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ex.gallardo.helppet.screens.start.StartScreen
import ex.gallardo.helppet.screens.welcome.WelcomeScreen
import ex.gallardo.helppet.utils.WelcomeScreens

@Composable
fun WelcomeNavController(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = WelcomeScreens.WelcomeScreen.route
    ) {
        composable(WelcomeScreens.WelcomeScreen.route) {
            WelcomeScreen(navController)
        }
        composable(WelcomeScreens.StartScreen.route) {
            StartScreen()
        }
    }
}