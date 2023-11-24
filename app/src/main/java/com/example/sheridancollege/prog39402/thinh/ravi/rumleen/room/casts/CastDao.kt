package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.User

// CountryDao.kt
@Dao
interface CastDao {
    @Query("SELECT * FROM casts")
    fun getAllCasts(): LiveData<List<Cast>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCast(country: Cast)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCasts(countries: List<Cast>)

}
