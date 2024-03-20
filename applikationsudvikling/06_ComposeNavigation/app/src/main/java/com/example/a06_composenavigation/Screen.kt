package com.example.a06_composenavigation

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Downloads: Screen(route = "downloads_screen")
    object Explore: Screen(route = "explore_screen")
}
