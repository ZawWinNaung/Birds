package com.example.birds.domain.usecase

import com.example.birds.data.repo.ApiRepository
import com.example.birds.domain.core.ApiResult
import com.example.birds.domain.core.Usecase
import com.example.birds.domain.model.Bird
import javax.inject.Inject

class GetRecentObservations @Inject constructor(
    private val repo: ApiRepository
) : Usecase<String, List<Bird>>() {
    override suspend fun provide(input: String): ApiResult<List<Bird>> {
        return try {
            val result = repo.getRecentObservations(input)
            if (result.isSuccess) {
                ApiResult.Success(result.getOrNull() ?: emptyList())
            } else {
                ApiResult.Error(result.exceptionOrNull())
            }
        } catch (e: Exception) {
            ApiResult.Error(e)
        }
    }
}