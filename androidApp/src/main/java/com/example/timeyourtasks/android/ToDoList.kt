package com.example.timeyourtasks.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    var checked by remember { mutableStateOf(true) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Switch(
            checked = checked,
            modifier = Modifier.padding(top = 40.dp),
            onCheckedChange = {
                checked = it
            }
        )
    }
}

@Composable
fun ToDoListMethod() {
    var showDone by remember { mutableStateOf(false) }
    val tasks = remember {
        mutableStateListOf(
            Task("Buy groceries", false),
            Task("Finish homework", true),
            Task("Go for a walk", false),
            Task("Read a book", true)
        )
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = if (showDone) "Showing: Done Tasks" else "Showing: To Do Tasks")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = showDone,
                onCheckedChange = { showDone = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        val filteredTasks = tasks.filter { it.done == showDone }

        LazyColumn {
            items(filteredTasks) { task ->
                TaskCard(task = task) { isChecked ->
                    task.done = isChecked
                }
            }
        }
    }
}

@Composable
fun TaskCard(task: Task, onCheckedChange: (Boolean) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.done,
                onCheckedChange = onCheckedChange
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = task.title,
                fontSize = 18.sp
            )
        }
    }
}