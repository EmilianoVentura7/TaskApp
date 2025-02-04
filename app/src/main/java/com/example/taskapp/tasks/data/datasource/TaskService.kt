package com.example.taskapp.tasks.data.datasource

import com.example.taskapp.tasks.data.model.TaskDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface TaskService {
    @GET("tasks")
    suspend fun getTasks(@Header("Authorization") token: String): List<TaskDTO>

    @POST("tasks")
    suspend fun createTask(@Body task: TaskDTO): Response<Unit>
}