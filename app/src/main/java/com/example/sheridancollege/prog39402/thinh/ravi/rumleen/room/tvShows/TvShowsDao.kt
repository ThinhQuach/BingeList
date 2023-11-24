package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.User

// CountryDao.kt
@Dao
interface TvShowsDao {
    @Query("SELECT * FROM tvshows WHERE isChildren = 'Yes'")
    fun getAllTVShows(): LiveData<List<TvShows>>

    @Query("SELECT * FROM tvshows WHERE isChildren = 'No'")
    fun getAllMoviesForAdult(): LiveData<List<TvShows>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTVShow(country: TvShows)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTVShows(countries: List<TvShows>)

    @Query("SELECT * FROM tvshows WHERE id = :id")
    fun getMovie(id: Int): LiveData<TvShows>

    @Query("UPDATE tvshows SET isInMyList = :isInMyList WHERE id = :id")
    suspend fun updateIsInMylist(isInMyList: String,id:Int)

    @Query("UPDATE tvshows SET isWatched = :isWatched WHERE id = :id")
    suspend fun updateIsWatched(isWatched: String,id:Int)

}
