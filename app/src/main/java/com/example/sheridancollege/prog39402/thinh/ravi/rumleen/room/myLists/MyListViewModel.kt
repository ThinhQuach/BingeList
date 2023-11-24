package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

}

