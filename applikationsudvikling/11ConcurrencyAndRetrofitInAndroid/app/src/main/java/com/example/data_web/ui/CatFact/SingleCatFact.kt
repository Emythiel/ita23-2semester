package com.example.data_web.ui.CatFact

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data_web.AddButton

@Composable
fun SingleCatFact(){
    val viewModel = viewModel<CatFactsViewModel>()

    Column {
        Column(
            Modifier.padding(horizontal = 32.dp).fillMaxHeight(0.4f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(Modifier.fillMaxHeight(0.75f).fillMaxWidth(), contentAlignment = Alignment.Center){
                Text(text = viewModel.currentCatFactString)
            }

            Row() {
                AddButton(value = "Like!", onButtonClick = {
                    viewModel.likeFact()
                })

                AddButton(value = "Next!", onButtonClick = {
                    viewModel.getRandomFact()
                })
            }

            Text(text = viewModel.likedFactsCount)


        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp, vertical = 16.dp)
                .verticalScroll(rememberScrollState())
                .border(width = 2.dp, color = Color.DarkGray)
        ) {
            Column() {
                viewModel.likedFacts.forEach { fact ->
                    Text(text = fact, modifier = Modifier.padding(8.dp, 16.dp))
                }
            }
        }
    }
}
