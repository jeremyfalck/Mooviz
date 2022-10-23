package com.jfalck.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jfalck.data.local.db.entity.FavoriteMovie

@Dao
interface FavoriteMovieDAO {
    @Query("SELECT * FROM favorite_movie")
    fun getAll(): List<FavoriteMovie>

    @Query("SELECT * FROM favorite_movie WHERE id IN (:movieId)")
    fun loadById(movieId: Int): FavoriteMovie

    @Query(
        "SELECT * FROM favorite_movie WHERE original_title LIKE :text OR " +
                "title LIKE :text LIMIT 1"
    )
    fun findByTitle(text: String): FavoriteMovie

    @Insert
    fun insertAll(vararg users: FavoriteMovie)

    @Delete
    fun delete(user: FavoriteMovie)
}
