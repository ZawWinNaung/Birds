package com.example.birds.data.repo

import com.example.birds.domain.model.Exercise

interface ApiRepository {
    suspend fun getExercises(): Result<List<Exercise>>
}