package com.jfalck.data.di

import android.content.Context
import androidx.room.Room
import com.jfalck.data.local.db.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesDatabaseModule {

    private const val DB_NAME = "movies-db"

    @Singleton
    @Provides
    fun providesMoviesDatabase(@ApplicationContext applicationContext: Context) =
        Room.databaseBuilder(
            applicationContext,
            MoviesDatabase::class.java, DB_NAME
        ).build()

}