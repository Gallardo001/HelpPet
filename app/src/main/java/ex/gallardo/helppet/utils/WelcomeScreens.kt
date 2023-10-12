package ex.gallardo.helppet.utils

sealed class WelcomeScreens(val route: String) {
    object WelcomeScreen: WelcomeScreens("welcome_screen")
    object StartScreen: WelcomeScreens("start_screen")
}
