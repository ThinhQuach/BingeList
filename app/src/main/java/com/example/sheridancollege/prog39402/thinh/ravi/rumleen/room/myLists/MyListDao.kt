package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.User

// CountryDao.kt
@Dao
interface MyListDao {
    @Query("SELECT * FROM mylist")
    fun getMyList(): LiveData<List<MyLists>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToMyList(mylist: MyLists)

    @Delete
    suspend fun deleteFromMylit(mylist:MyLists)

    @Query("DELETE FROM mylist WHERE name = :name")
    suspend fun deleteMyList(name: String)

    @Query("SELECT user_score FROM mylist WHERE id = :id")
    fun getUserScore(id: Int): LiveData<String>

    @Query("UPDATE mylist SET user_score = :user_score WHERE id = :id")
    suspend fun updateUserScore(user_score: String,id:Int)

    @Query("SELECT user_review FROM mylist WHERE id = :id")
    fun getUserReview(id: Int): LiveData<String>

    @Query("UPDATE mylist SET user_review = :user_review WHERE id = :id")
    suspend fun updateUserReview(user_review: String,id:Int)

    @Query("SELECT movieId FROM mylist WHERE id = :id")
    fun getMovieId(id: Int): LiveData<String>

    @Query("SELECT tvShowId FROM mylist WHERE id = :id")
    fun getTvShowId(id: Int): LiveData<String>

    @Query("SELECT type FROM mylist WHERE id = :id")
    fun getType(id: Int): LiveData<String>

}
