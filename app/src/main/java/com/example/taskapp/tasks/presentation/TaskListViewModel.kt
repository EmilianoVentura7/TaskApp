package com.example.taskapp.tasks.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskapp.tasks.domain.GetTasksUseCase
import com.example.taskapp.tasks.data.model.TaskDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskListViewModel(private val getTasksUseCase: GetTasksUseCase) : ViewModel() {
    private val _tasks = MutableStateFlow<List<TaskDTO>>(emptyList())
    val tasks: StateFlow<List<TaskDTO>> get() = _tasks

    fun getTasks(token: String) {
        viewModelScope.launch {
            _tasks.value = getTasksUseCase(token)
        }
    }
}