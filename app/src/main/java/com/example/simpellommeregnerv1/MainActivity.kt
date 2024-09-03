package com.example.simpellommeregnerv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Emergency
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.simpellommeregnerv1.ui.theme.SimpelLommeregnerV1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpelLommeregnerV1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calc(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Calc(modifier: Modifier = Modifier) {

    var num1 by remember { mutableStateOf("0") }
    var num2 by remember { mutableStateOf("0") }
    var result by remember { mutableStateOf("") }
    Column(modifier) {
        Text(text = "Calculator")

        OutlinedTextField(
            value = num1,
            onValueChange = {num1 = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            label = { Text(text = "Number 1")})

        OutlinedTextField(
            value = num2,
            onValueChange = {num2 = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            label = { Text(text = "Number 2")})

        Row {
            Button(onClick = {
                val number1 = num1.toIntOrNull() ?: 0
                val number2 = num2.toIntOrNull() ?: 0
                result = (number1 + number2).toString()
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add")
            }

            Button(onClick = {
                val number1 = num1.toIntOrNull() ?: 0
                val number2 = num2.toIntOrNull() ?: 0
                result = (number1 - number2).toString() }) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "Add")
            }

            Button(onClick = {
                val number1 = num1.toIntOrNull() ?: 0
                val number2 = num2.toIntOrNull() ?: 0
                result = (number1 * number2).toString() }) {
                Icon(
                    imageVector = Icons.Default.Emergency,
                    contentDescription = "Add")
            }

            Button(onClick = {
                val number1 = num1.toIntOrNull() ?: 0
                val number2 = num2.toIntOrNull() ?: 0
                result = (number1 / number2).toString() }) {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = "Add")
            }
        }

        Text(text = "Result: $result")
    }
}

@Preview(showBackground = true)
@Composable
fun CalcPreview() {
    Calc()
}