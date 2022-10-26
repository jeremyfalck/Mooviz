package com.jfalck.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jfalck.data.local.db.entity.ProductionCompany

class ProducionCompanyConverter {


    @TypeConverter
    fun fromImagesJson(productionCompanies: List<ProductionCompany>): String {
        return Gson().toJson(productionCompanies)
    }


    @TypeConverter
    fun toProductionCompaniesList(json: String): List<ProductionCompany> {
        val notesType = object : TypeToken<List<ProductionCompany>>() {}.type
        return Gson().fromJson(json, notesType)
    }
}