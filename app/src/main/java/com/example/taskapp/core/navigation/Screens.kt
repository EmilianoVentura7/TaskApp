package com.example.taskapp.core.navigation

sealed class Screens(val route: String) {
    object Login : Screens("login")
    object Register : Screens("register")
    object TaskList : Screens("taskList")
    object AddTask : Screens("addTask")
}