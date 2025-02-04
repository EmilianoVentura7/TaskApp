package com.example.taskapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskapp.login.presentation.LoginUI
import com.example.taskapp.login.presentation.LoginViewModel
import com.example.taskapp.register.presentation.RegisterUI
import com.example.taskapp.register.presentation.RegisterViewModel
import com.example.taskapp.tasks.presentation.AddTaskUI
import com.example.taskapp.tasks.presentation.AddTaskViewModel
import com.example.taskapp.tasks.presentation.TaskListUI
import com.example.taskapp.tasks.presentation.TaskListViewModel

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Login.route) {
        // Pantalla de Login
        composable(Screens.Login.route) {
            val viewModel: LoginViewModel = viewModel()
            LoginUI(navController = navController, viewModel = viewModel)
        }

        // Pantalla de Registro
        composable(Screens.Register.route) {
            val viewModel: RegisterViewModel = viewModel()
            RegisterUI(navController = navController, viewModel = viewModel)
        }

        // Pantalla de Lista de Tareas
        composable(Screens.TaskList.route) {
            val viewModel: TaskListViewModel = viewModel()
            TaskListUI(navController = navController, viewModel = viewModel)
        }

        // Pantalla de Agregar Tarea
        composable(Screens.AddTask.route) {
            val viewModel: AddTaskViewModel = viewModel()
            AddTaskUI(navController = navController, viewModel = viewModel)
        }
    }
}