package com.example.taskapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.taskapp.core.navigation.NavigationWrapper
import com.example.taskapp.ui.theme.TaskAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskAppTheme {
                // Surface es un contenedor que aplica el tema de la aplicación
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Usamos el NavigationWrapper para manejar la navegación
                    NavigationWrapper()
                }
            }
        }
    }
}