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

@Composable
fun DownloadsScreen() {
    Column{

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

            AddButton("X", onButtonClick = {})
            Text(text = "Downloads")

        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Image!")

            Column{
                Text(text = "Some Title")

                Text(text = "Name - Length")
            }
        }

    }
}

@Composable
private fun AddButton(value: String, onButtonClick: () -> Unit) {
    Button(onClick = onButtonClick,
        Modifier
            .padding(5.dp),
        colors = ButtonDefaults.buttonColors(Color.Gray))
    {
        Text(value, fontSize = 14.sp)
    }
}
