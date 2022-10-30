package com.jfalck.mooviz.di

import com.jfalck.data.di.MoviesRepositoryModule
import com.jfalck.domain.repository.MoviesRepository
import com.jfalck.domain.usecases.moviedetail.GetMovieDetailUseCase
import com.jfalck.domain.usecases.moviedetail.GetMovieDetailUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [MoviesRepositoryModule::class])
@InstallIn(SingletonComponent::class)
object GetMovieDetailUseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieDetailUseCaseModule(moviesRepository: MoviesRepository): GetMovieDetailUseCase =
        GetMovieDetailUseCaseImpl(moviesRepository)
}