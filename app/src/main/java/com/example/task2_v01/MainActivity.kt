package com.example.task2_v01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column (
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        Text(
            text="Счётчик",
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
            )
        Text(
            text="$count",
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 44.sp)
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    if (count > 0) {
                        count--
                    }
                },
                modifier = Modifier.weight(1f).padding(end = 4.dp),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text(
                    text="-1",
                    fontSize = 20.sp)
            }
            Button(
                onClick = {
                    if (count < 10) {
                        count++
                    }
                },
                modifier = Modifier.weight(1f).padding(start = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text="+1",
                    fontSize = 20.sp)
            }
        }

        Button(
            onClick = {
                count = 0
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text="Сбросить",
                fontSize = 20.sp)
        }
        if (count == 10) {
            Text (
                text="Максимум достигнут",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
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