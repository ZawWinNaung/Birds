package com.example.birds.data.repo

import com.example.birds.domain.model.Bird
import com.example.birds.domain.model.Exercise

interface ApiRepository {
    suspend fun getExercises(): Result<List<Exercise>>

    suspend fun getRecentObservations(regionCode: String): Result<List<Bird>>
}