package com.jfalck.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jfalck.data.local.db.entity.SpokenLanguage

class SpokenLanguageConverter {

    @TypeConverter
    fun fromSpokenLanguagesJson(spokenLanguages: List<SpokenLanguage>): String {
        return Gson().toJson(spokenLanguages)
    }


    @TypeConverter
    fun toSpokenLanguagesList(json: String): List<SpokenLanguage> {
        val notesType = object : TypeToken<List<SpokenLanguage>>() {}.type
        return Gson().fromJson(json, notesType)
    }

}
