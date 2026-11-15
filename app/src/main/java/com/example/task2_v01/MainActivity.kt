package com.example.task2_v01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Button(
                onClick = {
                    if (count > 0) {
                        count--
                    }
                },
                modifier = Modifier.weight(1f).padding(end = 4.dp).height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE6F1FF)
                )
            ) {
                Text(
                    text="-1",
                    fontSize = 20.sp,
                    color = Color.Black)
            }
            Button(
                onClick = {
                    if (count < 10) {
                        count++
                    }
                },
                modifier = Modifier.weight(1f).padding(start = 4.dp).height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff2577db)
                )
            ) {
                Text(
                    text="+1",
                    fontSize = 20.sp,
                    color = Color.White)
            }
        }

        Button(
            onClick = {
                count = 0
            },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp).height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE6F1FF)
            )
        ) {
            Text(
                text="Сбросить",
                fontSize = 20.sp,
                color = Color.Black)
        }
        if (count == 10) {
            Row(
                modifier = Modifier.fillMaxWidth().height(50.dp).clip(RoundedCornerShape(12.dp)).background(Color(0xFFABF7C7)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Максимум достигнут",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color(0xFF27873F)
                )
            }
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