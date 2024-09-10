package com.example.birds.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.birds.domain.core.ApiResult
import com.example.birds.domain.usecase.GetCategoryByLevels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoryByLevels: GetCategoryByLevels
) : ViewModel() {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories

    private val _onError = MutableStateFlow<Throwable?>(null)
    val onError: StateFlow<Throwable?> = _onError

    private val _onLoading = MutableStateFlow(false)
    val onLoading: StateFlow<Boolean> = _onLoading

    fun getCategories(level: String) {
        _onLoading.value = true
        viewModelScope.launch {
            when (val result = getCategoryByLevels.execute(level)) {
                is ApiResult.Success -> {
                    _onLoading.value = false
                    _categories.value = result.data
                }

                is ApiResult.Error -> {
                    _onLoading.value = false
                    _onError.value = result.throwable
                }
            }

        }
    }

    fun getExercisesByCategory(category:String){

    }
}