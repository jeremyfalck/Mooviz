package com.jfalck.data.di

import com.jfalck.data.mapper.movie.MovieMapper
import com.jfalck.data.mapper.topmovies.TopMoviesMapper
import com.jfalck.data.repository.MoviesRepositoryImpl
import com.jfalck.data.service.MoviesApiService
import com.jfalck.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [ApiModule::class, MovieMapperModule::class])
@InstallIn(SingletonComponent::class)
object MoviesRepositoryModule {

    @Singleton
    @Provides
    fun providesMoviesRepository(
        apiService: MoviesApiService, topMoviesMapper: TopMoviesMapper, movieMapper: MovieMapper
    ): MoviesRepository = MoviesRepositoryImpl(
        apiService, topMoviesMapper, movieMapper
    )
}