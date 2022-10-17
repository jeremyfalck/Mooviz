package com.jfalck.domain.di

import com.jfalck.data.di.ApiModule
import com.jfalck.data.mapper.movie.di.MovieMapperModule
import com.jfalck.data.mapper.topmovies.TopMoviesMapper
import com.jfalck.data.repository.MoviesRepositoryImpl
import com.jfalck.data.service.MoviesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [ApiModule::class, MovieMapperModule::class])
@InstallIn(SingletonComponent::class)
object MoviesRepositoryImplModule {

    @Singleton
    @Provides
    fun providesMoviesRepository(
        apiService: MoviesApiService, topMoviesMapper: TopMoviesMapper
    ) = MoviesRepositoryImpl(
        apiService, topMoviesMapper
    )
}