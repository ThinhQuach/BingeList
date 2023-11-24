package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.common

import androidx.room.TypeConverter
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts.Cast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// Add this class to your code
class Converters {
    @TypeConverter
    fun fromString(value: String): List<Cast> {
        val listType = object : TypeToken<List<Cast>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Cast>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
