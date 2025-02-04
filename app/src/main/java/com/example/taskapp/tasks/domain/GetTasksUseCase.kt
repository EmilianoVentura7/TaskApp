package com.example.taskapp.tasks.domain

import com.example.taskapp.tasks.data.repository.TaskRepository
import com.example.taskapp.tasks.data.model.TaskDTO

class GetTasksUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(token: String): List<TaskDTO> {
        return repository.getTasks(token)
    }
}