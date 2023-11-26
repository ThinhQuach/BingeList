package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.watchList

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class WatchListRepository {

    companion object{
        var myDatabase: AppDatabase?=null

        private fun intialiseDB(context: Context): AppDatabase?
        {
            return AppDatabase.getInstance(context)!!
        }

        fun insertIntoWatchList(context: Context,watchList: WatchList)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.watchListDao().insertIntoWatchList(watchList)
            }
        }

        fun getAllWatchList(context: Context): LiveData<List<WatchList>>
        {
            myDatabase = intialiseDB(context)
            return myDatabase!!.watchListDao().getWatchList()
        }

        suspend fun deleteFromWatchList(watchList: WatchList) {
            CoroutineScope(IO).launch{
                myDatabase!!.watchListDao().deleteFromWatchList(watchList)
            }
        }

        suspend fun deleteWatched(name: String) {
            myDatabase?.let { database ->
                CoroutineScope(IO).launch {
                    database.watchListDao()?.deleteWatched(name)
                }
            } ?: run {
                // Handle the case where myDatabase is null
                Log.e("WatchListRepository", "myDatabase is null")
            }
        }

        fun getUserScore(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.watchListDao().getUserScore(id)
        }

        fun updateUserScore(context: Context,user_score: String,id:Int)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.watchListDao().updateUserScore(user_score,id)
            }
        }

        fun getUserReview(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.watchListDao().getUserReview(id)
        }

        fun updateUserReview(context: Context,user_review: String,id:Int)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.watchListDao().updateUserReview(user_review,id)
            }
        }

        fun getMovieId(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.watchListDao().getMovieId(id)
        }

        fun getTvShowId(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.watchListDao().getTvShowId(id)
        }

        fun getType(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.watchListDao().getType(id)
        }
    }
}