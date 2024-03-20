package com.example.a04_ui_state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a04_ui_state.ui.theme._04uistateTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _04uistateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShoppingList()
                }
            }
        }
    }
}

@Composable
fun ShoppingList() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text("Shopping List", modifier = Modifier.padding(12.dp), fontSize = 30.sp, fontWeight = FontWeight.Bold)

        val listOfItems: List<String> = listOf(
            "Milk", "Cheese", "Flour", "Eggs", "Bread", "Wheat",
            "Soda", "Chocolate", "Strawberries", "Jam", "Honey",
            "Apples", "Pears", "Salad", "Chips", "Beef", "Candy"
        )
        ListItems(listOfItems)

    }
}



@Composable
fun ListItems(itemList: List<String>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth().padding(12.dp,0.dp)
    ) {
        items(itemList) { name ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 8.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(16.dp)),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.flour),
                    contentDescription = name,
                    modifier = Modifier.size(64.dp))
                Text(text = name, Modifier.padding(8.dp), fontSize = 24.sp)
                // Button
            }
        }
    }
}
