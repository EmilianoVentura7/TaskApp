package com.example.taskapp.tasks.data.model

data class TaskDTO(
    val id: Int? = null,
    val title: String,
    val description: String,
    val userId: Int
)