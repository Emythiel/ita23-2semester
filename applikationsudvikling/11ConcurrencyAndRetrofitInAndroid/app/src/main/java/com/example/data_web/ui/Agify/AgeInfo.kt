package com.example.data_web.ui.Agify

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data_web.AddButton

@Composable
fun AgeInfo() {
    val viewModel = viewModel<AgifyViewmodel>()

    Column{
        Text(text = viewModel.currentMessage)

        AddButton(value = "Check age", onButtonClick = {
            viewModel.getAge()
        })
    }
}
