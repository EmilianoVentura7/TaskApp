package com.example.taskapp.register.data.datasource

import com.example.taskapp.register.data.model.CreateUserRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("auth/register")
    suspend fun register(@Body request: CreateUserRequest): Response<Unit>
}