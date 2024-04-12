package com.example.data_web.ui.Welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.data_web.AddButton
import com.example.data_web.DTO.CatFact
import com.example.data_web.ui.Screen

@Composable
fun WelcomeScreen(
    navController: NavController
){
    Column(
        Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Welcome to the cat-facts application,\nan application with facts about cats")

        AddButton(value = "Get a Cat Fact!", onButtonClick = {
            navController.navigate(route = Screen.CatFactScreen.route)
        })
    }
}

