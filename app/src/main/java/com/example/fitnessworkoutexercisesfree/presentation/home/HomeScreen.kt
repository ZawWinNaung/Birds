package com.example.fitnessworkoutexercisesfree.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fitnessworkoutexercisesfree.domain.core.ApiResult
import com.example.fitnessworkoutexercisesfree.domain.model.Exercise

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val lazyListState = rememberLazyListState()

    val exercises = viewModel.exercises.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getExercises()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        when (exercises.value) {
            is ApiResult.Loading -> {

            }

            is ApiResult.Success -> {
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    val data = (exercises.value as ApiResult.Success<List<Exercise>>).data
                    items(data) { item ->
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = item.name ?: ""
                        )
                    }
                }
            }

            is ApiResult.Error -> {

            }
        }
    }
}