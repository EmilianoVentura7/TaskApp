package com.example.taskapp.login.data.datasource

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("auth/login")
    suspend fun login(@Body credentials: Map<String, String>): Response<Map<String, String>>
}