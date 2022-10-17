package com.jfalck.mooviz.feature.topmovies.di

import com.jfalck.domain.repository.MoviesRepository
import com.jfalck.domain.usecases.getTopMovies.GetTopMoviesUseCase
import com.jfalck.domain.usecases.getTopMovies.GetTopMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object GetTopMoviesUseCaseModule {

    @Singleton
    @Provides
    fun providesGetTopMoviesUseCase(
        moviesRepository: MoviesRepository
    ): GetTopMoviesUseCase =
        GetTopMoviesUseCaseImpl(moviesRepository)

}
