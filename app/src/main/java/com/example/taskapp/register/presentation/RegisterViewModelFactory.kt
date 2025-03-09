package com.example.taskapp.register.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskapp.register.domain.CreateUserUseCase

class RegisterViewModelFactory(
    private val createUserUseCase: CreateUserUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(createUserUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}