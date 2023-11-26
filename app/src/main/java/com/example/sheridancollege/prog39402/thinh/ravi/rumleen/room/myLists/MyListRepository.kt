package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.AppDatabase
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesRepository
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MyListRepository {

    companion object{
        var myDatabase: AppDatabase?=null

        private fun intialiseDB(context: Context): AppDatabase?
        {
            return AppDatabase.getInstance(context)!!
        }

        fun inserIntoMyList(context: Context,myList: MyLists)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.myListDao().insertToMyList(myList)
            }
        }


        fun getAllMyList(context: Context): LiveData<List<MyLists>>
        {
            myDatabase = intialiseDB(context)
            return myDatabase!!.myListDao().getMyList()
        }

        suspend fun deleteFromMyList(myList: MyLists) {
            CoroutineScope(IO).launch{
                myDatabase!!.myListDao().deleteFromMylit(myList)
            }
        }

        suspend fun deleteMyList(name: String) {
            myDatabase?.let { database ->
                CoroutineScope(IO).launch {
                    database.myListDao().deleteMyList(name)
                }
            } ?: run {
                Log.e("MyListRepository", "myDatabase is null")
            }
        }

        fun getUserScore(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.myListDao().getUserScore(id)
        }

        fun updateUserScore(context: Context,user_score: String,id:Int)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.myListDao().updateUserScore(user_score,id)
            }
        }

        fun getUserReview(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.myListDao().getUserReview(id)
        }

        fun updateUserReview(context: Context,user_review: String,id:Int)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.myListDao().updateUserReview(user_review,id)
            }
        }

        fun getMovieId(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.myListDao().getMovieId(id)
        }

        fun getTvShowId(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.myListDao().getTvShowId(id)
        }

        fun getType(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.myListDao().getType(id)
        }

    }
}