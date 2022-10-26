package com.jfalck.mooviz.di

import com.jfalck.data.di.MoviesRepositoryModule
import com.jfalck.domain.repository.MoviesRepository
import com.jfalck.domain.usecases.topmovies.GetTopMoviesUseCase
import com.jfalck.domain.usecases.topmovies.GetTopMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [MoviesRepositoryModule::class])
@InstallIn(SingletonComponent::class)
object GetTopMoviesUseCaseModule {

    @Singleton
    @Provides
    fun providesGetTopMoviesUseCase(
        moviesRepository: MoviesRepository
    ): GetTopMoviesUseCase =
        GetTopMoviesUseCaseImpl(moviesRepository)

}
