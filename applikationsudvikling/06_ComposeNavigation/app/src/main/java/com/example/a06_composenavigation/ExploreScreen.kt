package com.example.a06_composenavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ExploreScreen(
    navController: NavController
) {
    Column(modifier = Modifier
        .padding(16.dp)) {

        Row {
            AddButton("<-", onButtonClick = {
                navController.popBackStack()
            })

            TextField(value = "What are you looking for?", onValueChange = {})
        }

        Box(modifier = Modifier.padding(16.dp)){
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, shape = RoundedCornerShape(32.dp))
                .padding(16.dp)) {
                Row {
                    Column {
                        Text(text = "Body scan")
                        Text(text = "Meditation for body and mind")
                    }
                    Text(text = "image?")
                }
            }
        }

        Box(modifier = Modifier.padding(16.dp)){
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, shape = RoundedCornerShape(32.dp))
                .padding(16.dp))  {
                Row {
                    Column {
                        Text(text = "Breathing exercises")
                        Text(text = "BREATHE")
                    }
                    Text(text = "image?")
                }
            }
        }

        Box(modifier = Modifier.padding(16.dp)){
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, shape = RoundedCornerShape(32.dp))
                .padding(16.dp))  {
                Row {
                    Column {
                        Text(text = "Challenges")
                        Text(text = "Challenge thyself")
                    }
                    Text(text = "image?")
                }
            }
        }

    }
}

