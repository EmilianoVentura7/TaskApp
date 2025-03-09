package com.example.taskapp.login.data.repository

import com.example.taskapp.core.network.RetrofitHelper
import com.example.taskapp.login.data.datasource.LoginService

class LoginRepository {
    private val service = RetrofitHelper.retrofit.create(LoginService::class.java)

    suspend fun login(username: String, password: String): String? {
        val credentials = mapOf("username" to username, "password" to password)
        val response = service.login(credentials)
        return if (response.isSuccessful) {
            response.body()?.get("token")
        } else {
            null
        }
    }
}