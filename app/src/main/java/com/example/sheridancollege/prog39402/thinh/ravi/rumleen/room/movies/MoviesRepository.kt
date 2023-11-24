package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.AppDatabase
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MoviesRepository {

    companion object{
        var myDatabase: AppDatabase?=null

        private fun intialiseDB(context: Context): AppDatabase?
        {
            return AppDatabase.getInstance(context)!!
        }

        fun insertMovie(context: Context,movie: Movies)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.moviesDao().insertMovie(movie)
            }
        }

        fun updateIsInMylist(context: Context,isInMylist: String,name:String)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.moviesDao().updateIsInMylist(isInMylist,name)
            }
        }

        fun updateIsWatched(context: Context,isWatched: String,id:Int)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.moviesDao().updateIsWatched(isWatched,id)
            }
        }

        fun insertList(context: Context,countris:List<Movies>)
        {
            myDatabase= intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.moviesDao().insertMovies(countris)
            }
        }

        fun getAllMovies(context: Context): LiveData<List<Movies>>
        {
            myDatabase = intialiseDB(context)
            return myDatabase!!.moviesDao().getAllMovies()
        }
        fun getAllMoviesforAdult(context: Context): LiveData<List<Movies>>
        {
            myDatabase = intialiseDB(context)
            return myDatabase!!.moviesDao().getAllMoviesForAdult()
        }

        fun getMovie(context: Context,id: Int):LiveData<Movies>
        {
            myDatabase = intialiseDB(context)

           return myDatabase!!.moviesDao().getMovie(id)
        }

    }
}