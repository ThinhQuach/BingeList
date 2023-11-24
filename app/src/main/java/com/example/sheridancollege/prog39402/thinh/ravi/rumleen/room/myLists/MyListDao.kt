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

}
