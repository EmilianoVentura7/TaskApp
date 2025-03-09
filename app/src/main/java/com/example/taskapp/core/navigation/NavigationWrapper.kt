package com.example.taskapp.core.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskapp.login.data.repository.LoginRepository
import com.example.taskapp.login.domain.LoginUseCase
import com.example.taskapp.login.presentation.LoginUI
import com.example.taskapp.login.presentation.LoginViewModel
import com.example.taskapp.login.presentation.LoginViewModelFactory
import com.example.taskapp.register.data.repository.RegisterRepository
import com.example.taskapp.register.domain.CreateUserUseCase
import com.example.taskapp.register.presentation.RegisterUI
import com.example.taskapp.register.presentation.RegisterViewModel
import com.example.taskapp.register.presentation.RegisterViewModelFactory
import com.example.taskapp.tasks.data.repository.TaskRepository
import com.example.taskapp.tasks.domain.CreateTaskUseCase
import com.example.taskapp.tasks.domain.GetTasksUseCase
import com.example.taskapp.tasks.presentation.AddTaskUI
import com.example.taskapp.tasks.presentation.AddTaskViewModel
import com.example.taskapp.tasks.presentation.AddTaskViewModelFactory
import com.example.taskapp.tasks.presentation.TaskListUI
import com.example.taskapp.tasks.presentation.TaskListViewModel
import com.example.taskapp.tasks.presentation.TaskListViewModelFactory

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    // Crear las dependencias necesarias
    val loginRepository = LoginRepository()
    val loginUseCase = LoginUseCase(loginRepository)
    val loginViewModelFactory = LoginViewModelFactory(loginUseCase)

    val registerRepository = RegisterRepository()
    val createUserUseCase = CreateUserUseCase(registerRepository)
    val registerViewModelFactory = RegisterViewModelFactory(createUserUseCase)

    val taskRepository = TaskRepository()
    val getTasksUseCase = GetTasksUseCase(taskRepository)
    val taskListViewModelFactory = TaskListViewModelFactory(getTasksUseCase)

    val createTaskUseCase = CreateTaskUseCase(taskRepository)
    val addTaskViewModelFactory = AddTaskViewModelFactory(createTaskUseCase)

    NavHost(navController = navController, startDestination = Screens.Login.route) {
        // Pantalla de Login
        composable(Screens.Login.route) {
            val viewModel: LoginViewModel = viewModel(factory = loginViewModelFactory)
            LoginUI(navController = navController, viewModel = viewModel)
        }

        // Pantalla de Registro
        composable(Screens.Register.route) {
            val viewModel: RegisterViewModel = viewModel(factory = registerViewModelFactory)
            RegisterUI(navController = navController, viewModel = viewModel)
        }

        // Pantalla de Lista de Tareas
        composable(Screens.TaskList.route) {
            val loginViewModel: LoginViewModel = viewModel(factory = loginViewModelFactory)
            val token = loginViewModel.token.value

            if (token != null) {
                val viewModel: TaskListViewModel = viewModel(factory = taskListViewModelFactory)
                TaskListUI(navController = navController, viewModel = viewModel, token = token)
            } else {
                // Redirige al login si no hay token
                navController.navigate(Screens.Login.route)
            }
        }

        // Pantalla de Agregar Tarea
        composable(Screens.AddTask.route) {
            val loginViewModel: LoginViewModel = viewModel(factory = loginViewModelFactory)
            val token = loginViewModel.token.value

            if (token != null) {
                val viewModel: AddTaskViewModel = viewModel(factory = addTaskViewModelFactory)
                val taskListViewModel: TaskListViewModel = viewModel(factory = taskListViewModelFactory)
                AddTaskUI(
                    navController = navController,
                    viewModel = viewModel,
                    taskListViewModel = taskListViewModel,
                    token = token
                )
            } else {
                // Redirige al login si no hay token
                navController.navigate(Screens.Login.route)
            }
        }
    }
}