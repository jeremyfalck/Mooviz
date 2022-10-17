package com.jfalck.data.mapper.movie.di

import com.jfalck.data.mapper.movie.MovieMapper
import com.jfalck.data.mapper.movie.MovieMapperImpl
import com.jfalck.data.mapper.topmovies.TopMoviesMapper
import com.jfalck.data.mapper.topmovies.TopMoviesMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieMapperModule {

    @Singleton
    @Provides
    fun providesMovieMapper(): MovieMapper = MovieMapperImpl()

    @Singleton
    @Provides
    fun providesTopMoviesMapper(moviesMapper: MovieMapper): TopMoviesMapper =
        TopMoviesMapperImpl(moviesMapper)
}