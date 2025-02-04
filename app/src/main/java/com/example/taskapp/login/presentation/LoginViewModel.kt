package com.example.taskapp.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskapp.login.domain.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    fun login(username: String, password: String) {
        viewModelScope.launch {
            loginUseCase(username, password)
        }
    }
}