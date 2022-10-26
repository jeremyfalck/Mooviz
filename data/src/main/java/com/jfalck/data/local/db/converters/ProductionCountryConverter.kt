package com.jfalck.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jfalck.data.local.db.entity.ProductionCountry

class ProductionCountryConverter {

    @TypeConverter
    fun fromImagesJson(productionCountries: List<ProductionCountry>): String {
        return Gson().toJson(productionCountries)
    }


    @TypeConverter
    fun toProductionCountriesList(json: String): List<ProductionCountry> {
        val notesType = object : TypeToken<List<ProductionCountry>>() {}.type
        return Gson().fromJson(json, notesType)
    }

}

