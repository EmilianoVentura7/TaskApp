package com.example.taskapp.tasks.domain

import com.example.taskapp.tasks.data.repository.TaskRepository

class CreateTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(title: String, description: String) {
        repository.createTask(
            title, description,
            description = TODO()
        )
    }
}