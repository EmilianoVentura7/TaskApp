package com.example.taskapp.login.data.repository

import com.example.taskapp.core.network.RetrofitHelper
import com.example.taskapp.login.data.datasource.LoginService
import com.example.taskapp.login.data.model.LoginRequest
import com.example.taskapp.login.data.model.LoginResponse

class LoginRepository {
    private val service = RetrofitHelper.retrofit.create(LoginService::class.java)

    suspend fun login(username: String, password: String): Unit? {
        val request = LoginRequest(username, password)
        val response = service.login(request)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}
