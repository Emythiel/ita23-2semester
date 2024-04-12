package com.example.data_web.ui

sealed class Screen(val route: String) {
    object WelcomeScreen: Screen(route = "welcome_screen")
    object CatFactScreen: Screen(route = "catfactscreen_screen")
}
