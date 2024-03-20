package com.example.a06_composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a06_composenavigation.ui.theme._06_ComposeNavigationTheme

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a06_composenavigation.ui.theme._06_ComposeNavigationTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _06_ComposeNavigationTheme {

                navController = rememberNavController()
                SetupNavGraph(navController = navController)

                // A surface container using the 'background' color from the theme
                /*Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //HomeScreen()
                    DownloadsScreen()
                }*/
            }
        }
    }
}

@Composable
fun AddButton(value: String, onButtonClick: () -> Unit) {
    Button(onClick = onButtonClick,
        Modifier
            .padding(5.dp),
        colors = ButtonDefaults.buttonColors(Color.Gray))
    {
        Text(value, fontSize = 14.sp)
    }
}
