package com.example.data_web.ui.Agify

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun AgifyScreen(
    navController: NavController
) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        AgeInfo()
    }
}
