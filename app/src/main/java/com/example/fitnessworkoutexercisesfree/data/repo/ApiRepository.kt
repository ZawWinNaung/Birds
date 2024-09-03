package com.example.fitnessworkoutexercisesfree.data.repo

import com.example.fitnessworkoutexercisesfree.domain.model.Exercise

interface ApiRepository {
    suspend fun getExercises(): Result<List<Exercise>>
}