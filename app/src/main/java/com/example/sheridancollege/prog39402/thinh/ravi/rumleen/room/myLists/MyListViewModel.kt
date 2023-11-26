package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesRepository
import kotlinx.coroutines.launch

class MyListViewModel() : ViewModel() {


    fun insert(context: Context,myList: MyLists)
    {
        MyListRepository.inserIntoMyList(context,myList)
    }

     fun getAllMyList(context: Context):LiveData<List<MyLists>>
    {
        return MyListRepository.getAllMyList(context)
    }

    fun deleteFromMyList(myList: MyLists) {
        viewModelScope.launch {
            MyListRepository.deleteFromMyList(myList)
        }
    }

    fun deleteMyList(name: String) {
        viewModelScope.launch {
            MyListRepository.deleteMyList(name)
        }
    }

    fun getUserScore(context: Context,id:Int):LiveData<String>
    {
        return MyListRepository.getUserScore(context,id)
    }

    fun updateUserScore(context: Context,user_score: String,id:Int)
    {
        MyListRepository.updateUserScore(context,user_score,id)
    }

    fun getUserReview(context: Context,id:Int):LiveData<String>
    {
        return MyListRepository.getUserReview(context,id)
    }

    fun updateUserReview(context: Context,user_review: String,id:Int)
    {
        MyListRepository.updateUserReview(context,user_review,id)
    }

    fun getMovieId(context: Context,id:Int):LiveData<String>
    {
        return MyListRepository.getMovieId(context,id)
    }

    fun getTvShowId(context: Context,id:Int):LiveData<String>
    {
        return MyListRepository.getTvShowId(context,id)
    }

    fun getType(context: Context,id:Int):LiveData<String>
    {
        return MyListRepository.getType(context,id)
    }

}

