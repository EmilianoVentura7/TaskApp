package com.example.taskapp.tasks.data.repository

import com.example.taskapp.core.network.RetrofitHelper
import com.example.taskapp.tasks.data.datasource.TaskService
import com.example.taskapp.tasks.data.model.TaskDTO

class TaskRepository {
    private val service = RetrofitHelper.retrofit.create(TaskService::class.java)

    suspend fun getTasks(token: String): List<TaskDTO> {
        return service.getTasks("Bearer $token")
    }

    suspend fun createTask(token: String, title: String, description: String) {
        val task = TaskDTO(title = title, description = description, userId = 1)
        service.createTask("Bearer $token", task)
    }
}