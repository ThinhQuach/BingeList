package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.watchList

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists.MyListRepository
import kotlinx.coroutines.launch

class WatchListviewModel() : ViewModel() {


    fun insert(context: Context,watchList: WatchList)
    {
        WatchListRepository.insertIntoWatchList(context, watchList)
    }

     fun getAllWatchList(context: Context):LiveData<List<WatchList>>
    {
        return WatchListRepository.getAllWatchList(context)
    }

    fun deleteFromMyList(myList: WatchList) {
        viewModelScope.launch {
            WatchListRepository.deleteFromWatchList(myList)
        }
    }

    fun deleteWatched(name: String) {
        viewModelScope.launch {
            WatchListRepository.deleteWatched(name)
        }
    }

    fun getUserScore(context: Context,id:Int):LiveData<String>
    {
        return WatchListRepository.getUserScore(context,id)
    }

    fun updateUserScore(context: Context,user_score: String,id:Int)
    {
        WatchListRepository.updateUserScore(context,user_score,id)
    }

    fun getUserReview(context: Context,id:Int):LiveData<String>
    {
        return WatchListRepository.getUserReview(context,id)
    }

    fun updateUserReview(context: Context,user_review: String,id:Int)
    {
        WatchListRepository.updateUserReview(context,user_review,id)
    }

    fun getMovieId(context: Context,id:Int):LiveData<String>
    {
        return WatchListRepository.getMovieId(context,id)
    }

    fun getTvShowId(context: Context,id:Int):LiveData<String>
    {
        return WatchListRepository.getTvShowId(context,id)
    }

    fun getType(context: Context,id:Int):LiveData<String>
    {
        return WatchListRepository.getType(context,id)
    }



}

