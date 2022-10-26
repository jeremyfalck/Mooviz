package com.jfalck.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jfalck.data.local.db.converters.GenreConverter
import com.jfalck.data.local.db.converters.ProducionCompanyConverter
import com.jfalck.data.local.db.converters.ProductionCountryConverter
import com.jfalck.data.local.db.converters.SpokenLanguageConverter
import com.jfalck.data.local.db.dao.FavoriteMovieDAO
import com.jfalck.data.local.db.entity.FavoriteMovie

@Database(
    entities = [FavoriteMovie::class],
    version = 1
)
@TypeConverters(
    GenreConverter::class,
    ProducionCompanyConverter::class,
    ProductionCountryConverter::class,
    SpokenLanguageConverter::class
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun favoriteMovieDao(): FavoriteMovieDAO
}
