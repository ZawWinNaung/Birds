package com.example.fitnessworkoutexercisesfree.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessworkoutexercisesfree.data.repo.ApiRepository
import com.example.fitnessworkoutexercisesfree.domain.core.ApiResult
import com.example.fitnessworkoutexercisesfree.domain.model.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {

    private val _exercises = MutableStateFlow<ApiResult<List<Exercise>>>(ApiResult.Loading)
    val exercises: StateFlow<ApiResult<List<Exercise>>> = _exercises

    fun getExercises() {
        viewModelScope.launch {
            _exercises.value = ApiResult.Loading
            val result = apiRepository.getExercises()
            _exercises.value = if (result.isSuccess) {
                ApiResult.Success(result.getOrNull() ?: emptyList())
            } else {
                ApiResult.Error(result.exceptionOrNull()?.message ?: "Unknown Error")
            }
        }
    }
}