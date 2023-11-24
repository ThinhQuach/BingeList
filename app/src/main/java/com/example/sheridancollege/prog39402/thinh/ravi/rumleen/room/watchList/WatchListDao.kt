package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.watchList

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.User

// CountryDao.kt
@Dao
interface WatchListDao {
    @Query("SELECT * FROM watchlist")
    fun getWatchList(): LiveData<List<WatchList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoWatchList(watchList: WatchList)

    @Delete
    suspend fun deleteFromWatchList(watchList: WatchList)

    @Query("DELETE FROM watchlist WHERE name = :name")
    suspend fun deleteWatched(name: String)

}
