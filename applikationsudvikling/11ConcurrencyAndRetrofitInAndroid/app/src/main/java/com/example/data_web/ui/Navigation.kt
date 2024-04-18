/*
package com.example.data_web.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.data_web.ui.CatFact.CatFactScreen
import com.example.data_web.ui.Navigation.Welcome

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome"){
            Welcome()
        }
        composable("catFact"){
            CatFactScreen()
        }
    }
}
*/

package com.example.data_web.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.data_web.ui.Agify.AgifyScreen
import com.example.data_web.ui.CatFact.CatFactScreen
import com.example.data_web.ui.Welcome.WelcomeScreen
import com.example.data_web.ui.Screen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route
    ) {
        composable(
            route = Screen.WelcomeScreen.route
        ) {
            WelcomeScreen(navController = navController)
        }
        composable(
            route = Screen.CatFactScreen.route
        ) {
            CatFactScreen(navController = navController)
        }
        composable(
            route = Screen.AgifyScreen.route
        ) {
            AgifyScreen(navController = navController)
        }
    }
}
