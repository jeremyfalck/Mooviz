package com.jfalck.data.di

import com.jfalck.data.local.db.MoviesDatabase
import com.jfalck.data.local.mapper.FavoriteMovieMapper
import com.jfalck.data.remote.mapper.movie.MovieMapper
import com.jfalck.data.remote.mapper.topmovies.TopMoviesMapper
import com.jfalck.data.remote.service.MoviesApiService
import com.jfalck.data.repository.MoviesRepositoryImpl
import com.jfalck.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [ApiModule::class, MovieMapperModule::class, MoviesDatabaseModule::class, FavoriteMovieMapperModule::class])
@InstallIn(SingletonComponent::class)
object MoviesRepositoryModule {

    @Singleton
    @Provides
    fun providesMoviesRepository(
        apiService: MoviesApiService,
        moviesDatabase: MoviesDatabase,
        topMoviesMapper: TopMoviesMapper,
        movieMapper: MovieMapper,
        favoriteMovieMapper: FavoriteMovieMapper
    ): MoviesRepository = MoviesRepositoryImpl(
        apiService, moviesDatabase, topMoviesMapper, movieMapper, favoriteMovieMapper
    )
}