package com.example.taskapp.tasks.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskapp.tasks.domain.CreateTaskUseCase

class AddTaskViewModelFactory(
    private val createTaskUseCase: CreateTaskUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddTaskViewModel::class.java)) {
            return AddTaskViewModel(createTaskUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}