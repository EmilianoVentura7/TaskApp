package com.example.taskapp.tasks.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskapp.tasks.data.model.TaskDTO

@Composable
fun TaskListUI(
    navController: NavController,
    viewModel: TaskListViewModel
) {
    val tasks by viewModel.tasks.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { navController.navigate("addTask") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Task")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(tasks) { task ->
                TaskItem(task = task)
            }
        }
    }
}

@Composable
fun TaskItem(task: TaskDTO) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = task.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = task.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}