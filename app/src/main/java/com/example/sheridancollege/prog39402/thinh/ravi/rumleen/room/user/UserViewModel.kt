package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class UserViewModel() : ViewModel() {


    fun insert(context: Context,country: User)
    {
        UserRepository.insert(context,country)
    }

    fun updateUserPassword(context: Context,email: String,password:String)
    {
        UserRepository.updateUserPassword(context,email,password)
    }

     fun getAllUsers(context: Context):LiveData<List<User>>
    {
        return UserRepository.getAllUsers(context)
    }

    suspend fun isEmailExists(email: String): Boolean {
        return UserRepository.isEmailExists(email)
    }
    suspend fun verifyLogin(email: String, password: String): Boolean {
        return UserRepository.verifyLogin(email, password)
    }

    suspend fun getUserByEmail2(email: String): User {
        return UserRepository.getUserByEmail(email)
    }

}

