package com.jfalck.mooviz.di

import com.jfalck.data.di.MoviesRepositoryModule
import com.jfalck.domain.repository.MoviesRepository
import com.jfalck.domain.usecases.favoritemovies.RemoveFavoriteMovieUseCase
import com.jfalck.domain.usecases.favoritemovies.RemoveFavoriteMovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [MoviesRepositoryModule::class])
@InstallIn(SingletonComponent::class)
object RemoveFavoriteMovieUseCaseModule {

    @Singleton
    @Provides
    fun providesRemoveFavoriteMovieUseCase(
        moviesRepository: MoviesRepository
    ): RemoveFavoriteMovieUseCase =
        RemoveFavoriteMovieUseCaseImpl(moviesRepository)

}