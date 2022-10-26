package com.jfalck.mooviz.di

import com.jfalck.data.di.MoviesRepositoryModule
import com.jfalck.domain.repository.MoviesRepository
import com.jfalck.domain.usecases.favoritemovies.SetFavoriteMovieUseCase
import com.jfalck.domain.usecases.favoritemovies.SetFavoriteMovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [MoviesRepositoryModule::class])
@InstallIn(SingletonComponent::class)
object SetFavoriteMovieUseCaseModule {

    @Singleton
    @Provides
    fun providesSetFavoriteMovieUseCase(
        moviesRepository: MoviesRepository
    ): SetFavoriteMovieUseCase =
        SetFavoriteMovieUseCaseImpl(moviesRepository)

}