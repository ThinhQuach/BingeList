package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository {

    companion object{
        var myDatabase: AppDatabase?=null

        private fun intialiseDB(context: Context): AppDatabase?
        {
            return AppDatabase.getInstance(context)!!
        }

        fun insert(context: Context,country: User)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.userDao().insert(country)
            }
        }

        fun updateUserPassword(context: Context,email: String,password:String)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.userDao().updateUserPassword(password,email)
            }
        }


        fun getAllUsers(context: Context): LiveData<List<User>>
        {
            myDatabase = intialiseDB(context)
            return myDatabase!!.userDao().getAllUsers()
        }

        suspend fun getUserByEmail( email: String,): User
        {
            return myDatabase!!.userDao().getUserByEmail2(email)
        }

        suspend fun isEmailExists(email: String): Boolean {
            val count = myDatabase!!.userDao().isEmailExists(email)
            return count > 0
        }
        suspend fun verifyLogin(email: String, password: String): Boolean {
            val user = myDatabase!!.userDao().getUserByEmail(email)
            return user?.password == password
        }
    }
}