package com.example.taskapp.login.domain

import com.example.taskapp.login.data.repository.LoginRepository

class LoginUseCase(private val repository: LoginRepository) {
    suspend operator fun invoke(username: String, password: String) {
        repository.login(username, password)
    }
}