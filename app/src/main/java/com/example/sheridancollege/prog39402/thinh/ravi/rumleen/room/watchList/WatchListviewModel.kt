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

}

