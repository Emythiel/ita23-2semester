package com.example.a02_basic_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a02_basic_layout.ui.theme._02basiclayoutTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _02basiclayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WelcomeScreenLayout()
                    //OnboardingScreenLayout()
                }
            }
        }
    }
}

@Composable
fun WelcomeScreenLayout() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween){
        // Image
        Image(painter = painterResource(id = R.drawable.sleepscience), contentDescription = "Logo",
            Modifier
                .fillMaxWidth()
                .padding(start = 60.dp, 100.dp, 60.dp, 8.dp), contentScale = ContentScale.FillWidth)

        // Column Text
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text("SleepScience", Modifier.padding(8.dp), color = Color.DarkGray, fontSize = 40.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Text("Discover the secrets to better sleep", color = Color.DarkGray, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }

        // Bottom Box
        Box(
            Modifier
                .padding(24.dp)
                .shadow(4.dp, shape = RoundedCornerShape(30.dp))
                .background(Color.White, shape = RoundedCornerShape(30.dp))
                .fillMaxWidth(),
        ){
            Text("Start",
                Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, color = Color.Gray
            )
        }
    }
}

@Composable
fun OnboardingScreenLayout() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween){
        // Top bar thingy
        Row(Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween){
            Text("<-")
            PageCounter(2, 4)
        }

        // Choose technique thingies
        Column(Modifier.fillMaxWidth().padding(10.dp, 0.dp, 10.dp, 0.dp)){
            Text("Discover proven", fontSize = 16.sp, fontWeight = FontWeight.Black)
            Text("sleep improvement techniques", fontSize = 16.sp, fontWeight = FontWeight.Black)
            Text("Choose one or more techniques", Modifier.padding(0.dp,8.dp,0.dp,0.dp), fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }

        // Grid?!?!
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp), Modifier
                .padding(20.dp, 2.dp, 20.dp, 2.dp)
        ) {
            item {
                BoxGridItem("Exercise for better")
            }
            item {
                BoxGridItem("Read for relaxation")
            }
            item {
                BoxGridItem("Practice")
            }
            item {
                BoxGridItem("Create a sleep")
            }
            item {
                BoxGridItem("Sleep now")
            }
            item {
                BoxGridItem("Listen to soothing")
            }
            item {
                BoxGridItem("Write in a sleep")
            }
            item {
                BoxGridItem("Avoid screens")
            }
        }


        // Skip proceed thingy
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Box(
                Modifier
                    .padding(10.dp)
                    .shadow(4.dp, shape = RoundedCornerShape(30.dp))
                    .background(Color.White, shape = RoundedCornerShape(30.dp))
                    .fillMaxWidth(0.5f),
                contentAlignment = Alignment.Center
            ){
                Text("Skip", Modifier.padding(16.dp), color = Color.Gray, fontWeight = FontWeight.Bold)
            }

            Box(
                Modifier
                    .padding(10.dp)
                    .background(Color(0xFF800080), shape = RoundedCornerShape(30.dp))
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text("Proceed", Modifier.padding(16.dp), color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun BoxGridItem(text: String) {
    Box(
        Modifier
            .padding(12.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(30.dp))
            .fillMaxSize()
            .size(130.dp, 130.dp),
    ){
        Column {
            Image(painter = painterResource(id = R.drawable.weight), contentDescription = "Weight", Modifier
                .size(100.dp, 100.dp)
                .align(Alignment.CenterHorizontally)
            )
            Text(text, Modifier
                    .fillMaxWidth()
                    .padding(0.dp,0.dp,0.dp,12.dp),
                fontSize = 12.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun PageCounter(currentPage: Int, maxPage: Int) {
    Text("$currentPage/$maxPage")
}
