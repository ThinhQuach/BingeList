package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.watchList

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.AppDatabase
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists.MyListRepository
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
            CoroutineScope(IO).launch{
                MyListRepository.myDatabase!!.watchListDao().deleteWatched(name)
            }
        }

    }
}