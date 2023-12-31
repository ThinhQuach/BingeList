package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.AppDatabase
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TVShowsRepository {

    companion object{
        var myDatabase: AppDatabase?=null

        private fun intialiseDB(context: Context): AppDatabase?
        {
            return AppDatabase.getInstance(context)!!
        }

        fun insertTVShow(context: Context,tvShow: TvShows)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.tvShowsDao().insertTVShow(tvShow)
            }
        }

        fun updateIsInMylist(context: Context,isInMylist: String,id:Int)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.tvShowsDao().updateIsInMylist(isInMylist,id)
            }
        }

        fun updateIsWatched(context: Context,isWatched: String,id:Int)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.tvShowsDao().updateIsWatched(isWatched,id)
            }
        }

        fun getAllTvShowsForAdult(context: Context): LiveData<List<TvShows>>
        {
            myDatabase = intialiseDB(context)
            return myDatabase!!.tvShowsDao().getAllMoviesForAdult()
        }

        fun insertList(context: Context,tvShows:List<TvShows>)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.tvShowsDao().insertTVShows(tvShows)
            }
        }
        fun getAllTVShow(context: Context): LiveData<List<TvShows>>
        {
            myDatabase = intialiseDB(context)
            return myDatabase!!.tvShowsDao().getAllTVShows()
        }

        fun getMovie(context: Context,id: Int):LiveData<TvShows>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.tvShowsDao().getMovie(id)
        }

        fun getUserScore(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.tvShowsDao().getUserScore(id)
        }

        fun updateUserScore(context: Context,user_score: String,id:Int)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.tvShowsDao().updateUserScore(user_score,id)
            }
        }

        fun getUserReview(context: Context,id: Int):LiveData<String>
        {
            myDatabase = intialiseDB(context)

            return myDatabase!!.tvShowsDao().getUserReview(id)
        }

        fun updateUserReview(context: Context,user_review: String,id:Int)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.tvShowsDao().updateUserReview(user_review,id)
            }
        }
    }
}