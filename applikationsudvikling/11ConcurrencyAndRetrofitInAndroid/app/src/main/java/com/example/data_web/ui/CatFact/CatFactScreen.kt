package com.example.data_web.ui.CatFact

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.data_web.DTO.CatFact

@Composable
fun CatFactScreen(
    navController: NavController
){
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        SingleCatFact()
    }
}
