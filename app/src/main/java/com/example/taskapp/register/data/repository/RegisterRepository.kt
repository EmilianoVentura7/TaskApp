package com.example.taskapp.register.data.repository

import com.example.taskapp.core.network.RetrofitHelper
import com.example.taskapp.register.data.datasource.RegisterService
import com.example.taskapp.register.data.model.CreateUserRequest

class RegisterRepository {
    private val service = RetrofitHelper.retrofit.create(RegisterService::class.java)

    suspend fun register(username: String, password: String) {
        val request = CreateUserRequest(username, password)
        service.register(request)
    }
}