package com.example.taskapp.tasks.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskapp.tasks.domain.CreateTaskUseCase
import kotlinx.coroutines.launch

class AddTaskViewModel(
    private val createTaskUseCase: CreateTaskUseCase
) : ViewModel() {

    fun createTask(token: String, title: String, description: String) {
        viewModelScope.launch {
            createTaskUseCase(token, title, description)
        }
    }
}
