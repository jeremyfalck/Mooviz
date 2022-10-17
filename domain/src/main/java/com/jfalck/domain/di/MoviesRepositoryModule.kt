package com.jfalck.domain.di

import com.jfalck.data.repository.MoviesRepositoryImpl
import com.jfalck.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [MoviesRepositoryImplModule::class])
@InstallIn(SingletonComponent::class)
abstract class MoviesRepositoryModule {

    @Binds
    abstract fun bindMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository
}