package com.example.pizzarestaurant.di

import com.example.pizzarestaurant.data.Repository
import com.example.pizzarestaurant.data.source.local.LocalDataSource
import com.example.pizzarestaurant.utils.AppExecutors
import com.example.pizzarestaurant.domain.repository.IRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        localDataSource: LocalDataSource,
        appExecutors: AppExecutors
    ): IRepository {
        return Repository(
            localDataSource = localDataSource,
            appExecutors = appExecutors
        )
    }

}