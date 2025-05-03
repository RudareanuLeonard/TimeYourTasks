package com.example.timeyourtasks.android

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.timeyourtasks.Greeting


class WelcomePage : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WelcomePageMethod()
                }
            }
        }

    }
}

@Composable
fun WelcomePageMethod(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFB0E1FF), // You were missing full hex values
                        Color(0xFF1E3C72)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(), // Fill size to center content properly
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome!",
                fontSize = 70.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold

            )

            Text(
                text = "Let's have a productive day!",
                fontSize = 20.sp,
                color = Color.White,
//                fontWeight = FontWeight.Bold

            )
        }
    }

}

@Preview
@Composable
fun WelcomePagePreview() {
    MyApplicationTheme {
        WelcomePageMethod()
    }
}
