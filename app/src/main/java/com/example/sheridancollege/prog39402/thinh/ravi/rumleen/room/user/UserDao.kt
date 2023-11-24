package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// CountryDao.kt
@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(country: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(countries: List<User>)


    @Query("SELECT COUNT(*) FROM users WHERE email = :email")
    suspend fun isEmailExists(email: String): Int

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail2(email: String): User

    @Query("UPDATE users SET password = :passowrd WHERE email = :email")
    suspend fun updateUserPassword(passowrd: String,email:String)


}
