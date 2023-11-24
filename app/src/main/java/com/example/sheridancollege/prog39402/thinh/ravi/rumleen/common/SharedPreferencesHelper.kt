package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.common

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

    fun saveString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getString(key: String, defaultValue: String = ""): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }
    fun clearPreferences() {
        with(sharedPreferences.edit()) {
            clear()
            apply()
        }
    }
}


/*// Example usage in an activity or fragment
val sharedPreferencesHelper = SharedPreferencesHelper(this)

// Save a string
sharedPreferencesHelper.saveString("username", "JohnDoe")

// Retrieve a string
val username = sharedPreferencesHelper.getString("username", "DefaultUsername")*/
