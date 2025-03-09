package com.example.taskapp.tasks.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskapp.tasks.domain.GetTasksUseCase

class TaskListViewModelFactory(
    private val getTasksUseCase: GetTasksUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskListViewModel::class.java)) {
            return TaskListViewModel(getTasksUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}