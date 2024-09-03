package com.example.fitnessworkoutexercisesfree.di

import com.example.fitnessworkoutexercisesfree.data.repo.ApiRepository
import com.example.fitnessworkoutexercisesfree.data.repo.ApiRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindApiRepository(apiRepositoryImpl: ApiRepositoryImpl): ApiRepository
}