package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.User

// CountryDao.kt
@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies WHERE isChildren = 'Yes'")
    fun getAllMovies(): LiveData<List<Movies>>

    @Query("SELECT * FROM movies WHERE isChildren = 'No'")
    fun getAllMoviesForAdult(): LiveData<List<Movies>>

    @Query("SELECT * FROM movies WHERE id = :id")
    fun getMovie(id: Int): LiveData<Movies>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(country: Movies)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(countries: List<Movies>)

    @Query("UPDATE movies SET isInMyList = :isInMyList WHERE name = :name")
    suspend fun updateIsInMylist(isInMyList: String,name:String)

    @Query("UPDATE movies SET isWatched = :isWatched WHERE id = :id")
    suspend fun updateIsWatched(isWatched: String,id:Int)

    @Query("SELECT user_score FROM movies WHERE id = :id")
    fun getUserScore(id: Int): LiveData<String>

    @Query("UPDATE movies SET user_score = :user_score WHERE id = :id")
    suspend fun updateUserScore(user_score: String,id:Int)

    @Query("SELECT user_review FROM movies WHERE id = :id")
    fun getUserReview(id: Int): LiveData<String>

    @Query("UPDATE movies SET user_review = :user_review WHERE id = :id")
    suspend fun updateUserReview(user_review: String,id:Int)
}
