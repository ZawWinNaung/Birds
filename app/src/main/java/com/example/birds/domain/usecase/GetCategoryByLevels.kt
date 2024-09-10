package com.example.birds.domain.usecase

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import com.example.birds.data.repo.ApiRepository
import com.example.birds.domain.core.ApiResult
import com.example.birds.domain.core.Usecase
import javax.inject.Inject

class GetCategoryByLevels @Inject constructor(
    private val apiRepository: ApiRepository
) : Usecase<String, List<String>>() {
    override suspend fun provide(input: String): ApiResult<List<String>> {
        val result = apiRepository.getExercises()
        if (result.isSuccess) {
            var categoryList = mutableListOf<String>()
            result.getOrNull()?.let { data ->
                categoryList = data.mapNotNull {
                    val isLevel = it.level == input.toLowerCase(Locale.current)
                    it.category?.takeIf { category ->
                        category.isNotBlank() && isLevel
                    }
                }
                    .toSet()
                    .toMutableList()
            }
            return ApiResult.Success(categoryList)
        } else {
            return ApiResult.Error(result.exceptionOrNull())
        }
    }


}