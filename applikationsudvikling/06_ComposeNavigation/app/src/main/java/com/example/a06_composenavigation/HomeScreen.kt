package com.example.a06_composenavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController
) {
    Column{

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

            Text(text = "Welcome")

            // Burger menu button
            AddButton("...", onButtonClick = {})

        }

        Row {

            AddButton("Your Daily", onButtonClick = {})

            AddButton("Downloads", onButtonClick = {
                navController.navigate(route = Screen.Downloads.route)
            })

        }

        Row {

            AddButton("Timer", onButtonClick = {})

            AddButton("Sleep", onButtonClick = {})

        }

        Row {

            AddButton("Challenges", onButtonClick = {})

            AddButton("Emergency", onButtonClick = {})

        }

        // Image
        Text(text = "This is actually an image")

        AddButton("Explore", onButtonClick = {
            navController.navigate(route = Screen.Explore.route)
        })

    }
}
