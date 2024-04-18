package com.example.uxreportapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uxreportapp.ui.theme.UXReportAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UXReportAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun EventListView(goToSignup: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "List")
            Text(text = "Calendar")
        }

        Spacer(modifier = Modifier.padding(2.dp))

        Text(text = "Upcoming Events", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.padding(2.dp))

        Text(text = "Filters")

        Spacer(modifier = Modifier.padding(2.dp))

        Column() {
            EventListItem(
                title = "Paintball",
                description = "Kom med os og spil noget paintball! Vi tager til Amager for noget hygge maling",
                image = "IMAGE",
                date = "21-04-2024",
                location = "Amager",
                price = "30,-",
                spots = "24/30",
                goToSignup
            )
            EventListItem(
                title = "Tivoli",
                description = "Vi tager i tivoli og prøver rutsjebanen",
                image = "WOAH",
                date = "28-04-2024",
                location = "Tivoli",
                price = "15,-",
                spots = "18/50",
                goToSignup
            )
            EventListItem(
                title = "Fælledparken Hygge",
                description = "Vi holder picnic i fælledparken, kom med os og hyg lidt",
                image = "PICNIC",
                date = "93-04-2024",
                location = "Fælledparken",
                price = "Gratis",
                spots = "Kom Bare",
                goToSignup
            )
            EventListItem(
                title = "Lan Party i imperial",
                description = "idk hvordan vi fik plads til den, men vi gjorde det. Kom med pc eller bærbar og hyg med noget gaming på det storre lærred",
                image = "gamers rise up",
                date = "23-64-2039",
                location = "Imperial",
                price = "10,-",
                spots = "211/304",
                goToSignup
            )
            EventListItem(
                title = "Lan Party i palads",
                description = "idk hvordan vi fik plads til den, men vi gjorde det. Kom med pc eller bærbar og hyg med noget gaming på det storre lærred",
                image = "gamers rise up",
                date = "24-64-2039",
                location = "Palads",
                price = "10,-",
                spots = "14/30",
                goToSignup
            )
        }
    }
}

@Composable
fun EventListItem(title: String, description: String, image: String, date: String, location: String, price: String, spots: String, goToSignup:()->Unit) {
    Column(
        modifier = Modifier
            .padding(vertical = 7.dp)
            .clickable { goToSignup() }
    ) {
        Box(
            modifier = Modifier
                .border(width = 4.dp, color = Color.DarkGray, shape = RoundedCornerShape(10.dp))
        ) {
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = image,
                    modifier = Modifier
                        .size(100.dp)
                        .background(color = Color.Gray),
                    textAlign = TextAlign.Center)

                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                ) {
                    Text(text = title, fontSize = 24.sp)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Absolute.Left
                    ) {
                        Text(text = date)
                        Text(text = price, modifier = Modifier.padding(start = 16.dp))
                        Text(text = spots, modifier = Modifier.padding(start = 16.dp))
                    }

                    Text(text = description, fontSize = 14.sp, maxLines = 2, overflow = TextOverflow.Ellipsis)
                }
            }
        }
    }
}

@Composable
fun SignUp(goBack:()->Unit){
    Column {
        Text(text = "Event Signup", textAlign = TextAlign.Center, modifier = Modifier
            .fillMaxWidth()
            .height(150.dp))

        Row {
            Text(text = "Name   ", textAlign = TextAlign.Left)
            Text(text = "Box")
        }
        Row {
            Text(text = "Email ", textAlign = TextAlign.Left)
            Text(text = "Box")
        }
        Row {
            Text(text = "Phone ", textAlign = TextAlign.Left)
            Text(text = "Box")
        }

        Text(text = "Pay", textAlign = TextAlign.Center, modifier = Modifier
            .fillMaxWidth()
            .height(50.dp))

        Button(onClick = goBack) {
            Text(text = "Go Back")
        }
    }
}
