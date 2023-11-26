package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesRepository
import kotlinx.coroutines.launch

class TvShowsModel() : ViewModel() {

    fun insert(context: Context,tvShow: TvShows)
    {
        TVShowsRepository.insertTVShow(context,tvShow)
    }

     fun getAllTVSHows(context: Context):LiveData<List<TvShows>>
    {
        return TVShowsRepository.getAllTVShow(context)
    }

    fun getAllTVShowsforAdult(context: Context):LiveData<List<TvShows>>
    {
        return TVShowsRepository.getAllTvShowsForAdult(context)
    }

    fun insertTVShows(context: Context,tvShows: List<TvShows>) = viewModelScope.launch {
        TVShowsRepository.insertList(context,tvShows)
    }

    fun getMovie(context: Context,id:Int):LiveData<TvShows>
    {
        return TVShowsRepository.getMovie(context,id)
    }
    fun updateIsInMylist(context: Context,isinMyList: String,id:Int)
    {
        TVShowsRepository.updateIsInMylist(context,isinMyList,id)
    }
    fun updateIsWatched(context: Context,isWatched: String,id:Int)
    {
        TVShowsRepository.updateIsWatched(context,isWatched,id)
    }

    fun getUserScore(context: Context,id:Int):LiveData<String>
    {
        return TVShowsRepository.getUserScore(context,id)
    }

    fun updateUserScore(context: Context,user_score: String,id:Int)
    {
        TVShowsRepository.updateUserScore(context,user_score,id)
    }

    fun getUserReview(context: Context,id:Int):LiveData<String>
    {
        return TVShowsRepository.getUserReview(context,id)
    }

    fun updateUserReview(context: Context,user_review: String,id:Int)
    {
        TVShowsRepository.updateUserReview(context,user_review,id)
    }

}

