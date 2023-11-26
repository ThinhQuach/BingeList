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

    @Query("SELECT user_score FROM watchlist WHERE id = :id")
    fun getUserScore(id: Int): LiveData<String>

    @Query("UPDATE watchlist SET user_score = :user_score WHERE id = :id")
    suspend fun updateUserScore(user_score: String,id:Int)

    @Query("SELECT user_review FROM watchlist WHERE id = :id")
    fun getUserReview(id: Int): LiveData<String>

    @Query("UPDATE watchlist SET user_review = :user_review WHERE id = :id")
    suspend fun updateUserReview(user_review: String,id:Int)

    @Query("SELECT movieId FROM watchlist WHERE id = :id")
    fun getMovieId(id: Int): LiveData<String>

    @Query("SELECT tvShowId FROM watchlist WHERE id = :id")
    fun getTvShowId(id: Int): LiveData<String>

    @Query("SELECT type FROM watchlist WHERE id = :id")
    fun getType(id: Int): LiveData<String>

}
