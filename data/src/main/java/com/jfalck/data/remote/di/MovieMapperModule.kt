package com.jfalck.data.remote.di

import com.jfalck.data.remote.mapper.movie.MovieMapper
import com.jfalck.data.remote.mapper.movie.MovieMapperImpl
import com.jfalck.data.remote.mapper.topmovies.TopMovieMapper
import com.jfalck.data.remote.mapper.topmovies.TopMovieMapperImpl
import com.jfalck.data.remote.mapper.topmovies.TopMoviesMapper
import com.jfalck.data.remote.mapper.topmovies.TopMoviesMapperImpl
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
    fun providesTopMovieMapper(): TopMovieMapper = TopMovieMapperImpl()

    @Singleton
    @Provides
    fun providesTopMoviesMapper(moviesMapper: TopMovieMapper): TopMoviesMapper =
        TopMoviesMapperImpl(moviesMapper)

    @Singleton
    @Provides
    fun providesMovieMapper(): MovieMapper = MovieMapperImpl()
}