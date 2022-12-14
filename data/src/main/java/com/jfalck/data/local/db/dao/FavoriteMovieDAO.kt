package com.jfalck.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jfalck.data.local.db.entity.FavoriteMovie
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDAO {
    @Query("SELECT * FROM favorite_movie")
    suspend fun getAll(): List<FavoriteMovie>

    @Query("SELECT * FROM favorite_movie")
    fun getAllAsFlow(): Flow<List<FavoriteMovie>>

    @Query(
        "SELECT * FROM favorite_movie WHERE id = :movieId"
    )
    suspend fun findById(movieId: Int): FavoriteMovie?

    @Insert
    suspend fun insertAll(vararg users: FavoriteMovie)

    @Query("DELETE FROM favorite_movie WHERE id = :movieId")
    suspend fun deleteById(movieId: Int)
}
