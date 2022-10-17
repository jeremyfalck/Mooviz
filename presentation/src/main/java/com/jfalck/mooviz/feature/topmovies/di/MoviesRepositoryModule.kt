package com.jfalck.mooviz.feature.topmovies.di

import com.jfalck.data.di.ApiModule
import com.jfalck.data.mapper.movie.di.MovieMapperModule
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
        apiService: MoviesApiService, topMoviesMapper: TopMoviesMapper
    ): MoviesRepository = MoviesRepositoryImpl(
        apiService, topMoviesMapper
    )

    /*@Binds
    abstract fun bindMoviesRepository(impl: MoviesRepositoryImpl): MoviesRepository*/

}