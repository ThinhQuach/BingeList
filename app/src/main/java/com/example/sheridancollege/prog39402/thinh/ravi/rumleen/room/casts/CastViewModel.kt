package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesRepository
import kotlinx.coroutines.launch

class CastViewModel() : ViewModel() {


    fun insertCast(context: Context,cast: Cast)
    {
        CastRepository.insertCast(context,cast)
    }

     fun getAllCasts(context: Context):LiveData<List<Cast>>
    {
        return CastRepository.getAllCasts(context)
    }
    fun insertCasts(context: Context,casts: List<Cast>) = viewModelScope.launch {
        CastRepository.insertList(context,casts)
    }
}

