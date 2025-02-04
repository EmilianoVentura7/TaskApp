package com.example.taskapp.tasks.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddTaskUI(
    navController: NavController,
    viewModel: AddTaskViewModel
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.createTask(title, description)
                navController.popBackStack() // Regresar a la pantalla anterior
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Task")
        }
    }
}