package com.example.timeyourtasks.android

import android.os.Bundle
import android.widget.Switch
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Switch
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp


class ToDoList : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ToDoListMethod()
                }
            }
        }
    }

}


@Composable
fun SwitchMinimalExample() {
    // This remembers the state of the switch
    var checked by remember { mutableStateOf(true) }

    Row(
//        verticalAlignment = Alignment.CenterVertically,  // Vertically center the content
        horizontalArrangement = Arrangement.Center
    ) {
        // You can add a label or description here
        Text(text = "Switch is ${if (checked) "ON" else "OFF"}")

        // The Switch itself
        Switch(
            checked = checked,
            modifier = Modifier.padding(top = 40.dp),
            onCheckedChange = {
                checked = it // Update the state when the switch is toggled
            }
        )
    }
}


@Composable
    fun ToDoListMethod(){

        SwitchMinimalExample()

    }

