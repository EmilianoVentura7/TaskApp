package com.example.taskapp.register.domain

import com.example.taskapp.register.data.repository.RegisterRepository

class CreateUserUseCase(private val repository: RegisterRepository) {
    suspend operator fun invoke(username: String, password: String) {
        repository.register(username, password)
    }
}