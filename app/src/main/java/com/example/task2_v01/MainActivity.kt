package com.example.task2_v01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.task2_v01.ui.theme.Task2_v01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task2_v01Theme {
                CounterScreen()
            }
        }
    }
}

@Composable
fun CounterScreen() {
    var count by remember {
        mutableIntStateOf(0)
    }
    Column {
        Text("Счётчик")
        Text("$count")
        Button(
            onClick = {
                if (count < 10) {
                    count++
                }
            }
        ) {
            Text("+1")
        }
        Button(
            onClick = {
                if (count > 0) {
                    count--
                }
            }
        ) {
            Text("-1")
        }
        Button(
            onClick = {
                count = 0
            }
        ) {
            Text("Сбросить")
        }
        if (count == 10) {
            Text (
                text="Максимум достигнут"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Task2_v01Theme {
        CounterScreen()
    }
}