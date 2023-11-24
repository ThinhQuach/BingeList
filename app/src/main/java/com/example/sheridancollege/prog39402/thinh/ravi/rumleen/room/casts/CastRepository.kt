package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.AppDatabase
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CastRepository {

    companion object{
        var myDatabase: AppDatabase?=null

        private fun intialiseDB(context: Context): AppDatabase?
        {
            return AppDatabase.getInstance(context)!!
        }

        fun insertCast(context: Context,cast: Cast)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.castDao().insertCast(cast)
            }
        }


        fun getAllCasts(context: Context): LiveData<List<Cast>>
        {
            myDatabase = intialiseDB(context)
            return myDatabase!!.castDao().getAllCasts()
        }

        fun insertList(context: Context,casts:List<Cast>)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.castDao().insertCasts(casts)
            }
        }


    }
}