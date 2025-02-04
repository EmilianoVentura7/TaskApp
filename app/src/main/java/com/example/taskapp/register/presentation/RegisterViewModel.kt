package com.example.taskapp.register.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskapp.register.domain.CreateUserUseCase
import kotlinx.coroutines.launch

class RegisterViewModel(private val createUserUseCase: CreateUserUseCase) : ViewModel() {
    fun register(username: String, password: String) {
        viewModelScope.launch {
            createUserUseCase(username, password)
        }
    }
}