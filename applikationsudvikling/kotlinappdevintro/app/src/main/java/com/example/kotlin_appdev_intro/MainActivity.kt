package com.example.kotlin_appdev_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_appdev_intro.ui.theme.KotlinappdevintroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinappdevintroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //BoxText()
                    //DKFlag()
                    //TextAlignment()
                    DigitalBiznizCard()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column{
        Text("Hello $name", modifier = Modifier)
        Text("Hello $name", modifier = Modifier)
        Text("Hello $name", modifier = Modifier)
    }
}

@Composable
fun BoxText(modifier: Modifier = Modifier){
    Column{
        Row{
            Box(modifier = Modifier
                .background(Color.Red)
                .fillMaxHeight(0.03f)
                .fillMaxWidth(0.23f)
            ){
                Text("Hello Hello!!")
            }
            Box(modifier = Modifier
                .background(Color.Yellow)
                .fillMaxHeight(0.03f)
                .fillMaxWidth()
            )
        }

        Row{
            Box(modifier = Modifier
                .background(Color.Blue)
                .fillMaxHeight(0.03f)
                .fillMaxWidth(0.35f)
            ){
                Text("Hello Hello Again!!")
            }
            Box(modifier = Modifier
                .background(Color.Yellow)
                .fillMaxHeight(0.03f)
                .fillMaxWidth()
            )
        }
        Row{
            Box(modifier = Modifier
                .background(Color.Green)
                .fillMaxHeight(0.03f)
                .fillMaxWidth(0.65f)
            ){
                Text("Hello Hello Again again my friend!!")
            }
            Box(modifier = Modifier
                .background(Color.Yellow)
                .fillMaxHeight(0.03f)
                .fillMaxWidth()
            )
        }
        Row{
            Box(modifier = Modifier
                .background(Color.Cyan)
                .fillMaxHeight(0.03f)
                .fillMaxWidth(0.65f)
            ){
                Text("asd")
            }
        }
    }
}

@Composable
fun DKFlag(modifier: Modifier = Modifier){
    Column{
        Row{
            Box(modifier = Modifier
                .background(Color.Red)
                .fillMaxHeight(0.15f)
                .fillMaxWidth(0.3f)
            )
            Box(modifier = Modifier
                .background(Color.White)
                .fillMaxHeight(0.15f)
                .fillMaxWidth(0.1f)
            )
            Box(modifier = Modifier
                .background(Color.Red)
                .fillMaxHeight(0.15f)
                .fillMaxWidth()
            )
        }
        Row{
            Box(modifier = Modifier
                .background(Color.White)
                .fillMaxHeight(0.05f)
                .fillMaxWidth()
            )
        }
        Row{
            Box(modifier = Modifier
                .background(Color.Red)
                .fillMaxHeight(0.2f)
                .fillMaxWidth(0.3f)
            )
            Box(modifier = Modifier
                .background(Color.White)
                .fillMaxHeight(0.2f)
                .fillMaxWidth(0.1f)
            )
            Box(modifier = Modifier
                .background(Color.Red)
                .fillMaxHeight(0.2f)
                .fillMaxWidth()
            )
        }
    }
}

@Composable
fun TextAlignment(modifier: Modifier = Modifier){
    Column{
        Row{
            Box(modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(0.5f)
                .border(1.dp, Color.Black),
                contentAlignment = Alignment.Center
            ){
                Text("Center")
            }
            Box(modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .border(1.dp, Color.Black),
                contentAlignment = Alignment.TopEnd
            ){
                Text("Right Top")
            }
        }
        Row{
            Box(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5f)
                .border(1.dp, Color.Black),
                contentAlignment = Alignment.BottomCenter
            ){
                Text("Bottom")
            }
            Box(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .border(1.dp, Color.Black),
                contentAlignment = Alignment.TopStart
            ){
                Text("Top Left")
            }
        }
    }
}
@Composable
fun DigitalBiznizCard() {
    Column {
        Row {
            Box(modifier = Modifier
                .fillMaxHeight(0.1f)
                .fillMaxWidth(0.5f),
                contentAlignment = Alignment.TopStart
            ){
                Text("123 456 789")
            }
            Box(modifier = Modifier
                .fillMaxHeight(0.1f)
                .fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ){
                Text("Cool Bizniz Place")
            }
        }
        Row {
            Box(modifier = Modifier
                .fillMaxHeight(0.1f)
                .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text("Creed Bratton")
            }
        }
        Row {
            Box(modifier = Modifier
                .fillMaxHeight(0.2f)
                .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text("123 Cool Bizniz Street Cred")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //Layout()
}
