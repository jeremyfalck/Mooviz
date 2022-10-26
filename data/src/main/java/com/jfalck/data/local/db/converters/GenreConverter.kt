package com.jfalck.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jfalck.data.local.db.entity.Genre

class GenreConverter {

    @TypeConverter
    fun fromImagesJson(genres: List<Genre>): String {
        return Gson().toJson(genres)
    }


    @TypeConverter
    fun toGenresList(json: String): List<Genre> {
        val notesType = object : TypeToken<List<Genre>>() {}.type
        return Gson().fromJson(json, notesType)
    }

}