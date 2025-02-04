package com.example.taskapp.login.data.datasource

import com.example.taskapp.login.data.model.LoginRequest
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Body

interface LoginService {
    @POST("auth/login")
    suspend fun login(@Body credentials: LoginRequest): Response<Unit>
}