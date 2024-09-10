package com.example.birds.data

import com.example.birds.domain.model.Bird
import com.example.birds.domain.model.Exercise
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("dist/exercises.json")
    suspend fun getExercises(): Response<List<Exercise>>

    @GET("data/obs/{regionCode}/recent")
    suspend fun getRecentObservations(
        @Path("regionCode") regionCode: String
    ): Response<List<Bird>>
}