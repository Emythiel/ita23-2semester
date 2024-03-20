package com.example.a03_ui_state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a03_ui_state.ui.theme._03uistateTheme
import java.util.Stack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _03uistateTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier.background(Color.Black)
                ) {
                    CalculatorLayout()
                }
            }
        }
    }
}

@Composable
fun AddButton(value: String, fontSize: Int = 44, buttonWidth: Int = 75, bgColor: Color, onButtonClick: () -> Unit) {
    Button(onClick = onButtonClick,
        Modifier
            .padding(5.dp)
            .size(buttonWidth.dp, 75.dp),
        colors = ButtonDefaults.buttonColors(bgColor))
    {
        Text(value, fontSize = fontSize.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberDisplay(value: String) {
    TextField(
        value = value,
        onValueChange = {},
        modifier = Modifier
            .padding(32.dp, 0.dp, 48.dp, 12.dp),
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 64.sp,
            textAlign = TextAlign.End
        ),
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Black)
    )
}

@Composable
fun CalculatorLayout() {
    var resultDisplay by remember {
        mutableStateOf("0")
    }
    var secretMode by remember {
        mutableStateOf("false")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom){
        // NumberDisplay
        Row{
            NumberDisplay(resultDisplay)
        }
        //Row = AC +/- % /
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            AddButton("AC", fontSize = 20, bgColor = Color.Gray, onButtonClick = {
                if (secretMode == "false") {
                    secretMode = "true"
                } else {
                    secretMode = "false"
                }
            })
            AddButton("+/-", fontSize = 20, bgColor = Color.Gray, onButtonClick = {
                println("+/-")
            })
            AddButton("%", fontSize = 40, bgColor = Color.Gray, onButtonClick = {
                println("%")
            })
            AddButton("/", fontSize = 40, bgColor = Color(0xFFFFA500), onButtonClick = {
                println("/")
            })
        }

        //Row = 7 8 9 *
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            AddButton("7", bgColor = Color.DarkGray, onButtonClick = {
                resultDisplay += 7
            })
            AddButton("8", bgColor = Color.DarkGray, onButtonClick = {
                resultDisplay += 8
            })
            AddButton("9", bgColor = Color.DarkGray, onButtonClick = {
                resultDisplay += 9
            })
            AddButton("x", bgColor = Color(0xFFFFA500), onButtonClick = {
                println("*")
            })
        }

        //Row = 4 5 6 -
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            AddButton("4", bgColor = Color.DarkGray, onButtonClick = {
                resultDisplay += 4
            })
            AddButton("5", bgColor = Color.DarkGray, onButtonClick = {
                resultDisplay += 5
            })
            AddButton("6", bgColor = Color.DarkGray, onButtonClick = {
                resultDisplay += 6
            })
            AddButton("-", bgColor = Color(0xFFFFA500), onButtonClick = {
                println("-")
            })
        }

        //Row = 1 2 3 +
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            AddButton("1", bgColor = Color.DarkGray, onButtonClick = {
                resultDisplay += 1
            })
            AddButton("2", bgColor = Color.DarkGray, onButtonClick = {
                resultDisplay += 2
            })
            AddButton("3", bgColor = Color.DarkGray, onButtonClick = {
                resultDisplay += 3
            })
            AddButton("+", bgColor = Color(0xFFFFA500), onButtonClick = {
                resultDisplay += "+"
            })
        }

        //Row = 0 . =
        Row(
            Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 24.dp),
            horizontalArrangement = Arrangement.Center
        ){
            AddButton("0", buttonWidth = 160, bgColor = Color.DarkGray, onButtonClick = {
                resultDisplay += 0
            })
            AddButton(".", bgColor = Color.DarkGray, onButtonClick = {
                println(".")
            })
            AddButton("=", bgColor = Color(0xFFFFA500), onButtonClick = {
                var result: Int = getResult(resultDisplay)
                if (secretMode == "false") {
                    resultDisplay = "420"
                } else {
                    resultDisplay = result.toString()
                }
            })
        }
    }
}


fun getResult(expression: String): Int {
    val tokens = tokenizeExpression(expression)
    return evaluateTokens(tokens)
}

fun tokenizeExpression(expression: String): List<String> {
    val regex = Regex("([*+/-])|([0-9]+)")
    return regex.findAll(expression).map { it.value }.toList()
}

fun evaluateTokens(tokens: List<String>): Int {
    val numberStack = Stack<Int>()
    val operatorStack = Stack<Char>()

    for (token in tokens) {
        when {
            token.isNumber() -> numberStack.push(token.toInt())
            token.isOperator() -> {
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), token[0])) {
                    val result = applyOperation(numberStack.pop(), numberStack.pop(), operatorStack.pop())
                    numberStack.push(result)
                }
                operatorStack.push(token[0])
            }
        }
    }

    while (!operatorStack.isEmpty()) {
        val result = applyOperation(numberStack.pop(), numberStack.pop(), operatorStack.pop())
        numberStack.push(result)
    }

    return numberStack.pop()
}

fun String.isNumber() = this.matches(Regex("\\d+"))
fun String.isOperator() = this.matches(Regex("[*+/-]"))
fun hasHigherPrecedence(op1: Char, op2: Char): Boolean {
    if (op1 == '*' || op1 == '/') return true
    if (op2 == '+' || op2 == '-') return true
    return false
}

fun applyOperation(a: Int, b: Int, op: Char): Int {
    return when (op) {
        '+' -> a + b
        '-' -> b - a
        '*' -> a * b
        '/' -> b / a
        else -> throw IllegalArgumentException("Unknown operator: $op")
    }
}
