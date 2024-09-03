package com.example.fitnessworkoutexercisesfree.data

import com.example.fitnessworkoutexercisesfree.domain.model.Exercise
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("dist/exercises.json")
    suspend fun getExercises(): Response<List<Exercise>>
}