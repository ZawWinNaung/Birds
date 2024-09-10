package com.example.birds.di

import com.example.birds.data.repo.ApiRepository
import com.example.birds.data.repo.ApiRepositoryImpl
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