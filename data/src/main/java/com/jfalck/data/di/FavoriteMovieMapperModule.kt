package com.jfalck.data.di

import com.jfalck.data.local.mapper.FavoriteMovieMapper
import com.jfalck.data.local.mapper.FavoriteMovieMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoriteMovieMapperModule {

    @Singleton
    @Provides
    fun providesFavoriteMovieMapper(): FavoriteMovieMapper = FavoriteMovieMapperImpl()


}