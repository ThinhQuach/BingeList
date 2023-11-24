package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.UserRepository
import kotlinx.coroutines.launch

class MoviesViewModel() : ViewModel() {


    fun insert(context: Context,movie: Movies)
    {
        MoviesRepository.insertMovie(context,movie)
    }

     fun getAllMoviesData(context: Context):LiveData<List<Movies>>
    {
        return MoviesRepository.getAllMovies(context)
    }
    fun getAllMoviesDataforAdult(context: Context):LiveData<List<Movies>>
    {
        return MoviesRepository.getAllMoviesforAdult(context)
    }

    fun getMovie(context: Context,id:Int):LiveData<Movies>
    {
        return MoviesRepository.getMovie(context,id)
    }

    fun insertMovies(context: Context,countries: List<Movies>) = viewModelScope.launch {
        MoviesRepository.insertList(context,countries)
    }
    fun updateIsInMylist(context: Context,isinMyList: String,name:String)
    {
        MoviesRepository.updateIsInMylist(context,isinMyList,name)
    }
    fun updateIsWatched(context: Context,isWatched: String,id:Int)
    {
        MoviesRepository.updateIsWatched(context,isWatched,id)
    }
}

