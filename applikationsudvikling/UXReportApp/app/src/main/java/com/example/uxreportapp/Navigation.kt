package com.example.uxreportapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "front") {
        composable("signup") {
            SignUp(goBack = { navController.navigate("front") })
        }
        composable("front"){
            EventListView(goToSignup = { navController.navigate("signup") })
        }
    }
}
