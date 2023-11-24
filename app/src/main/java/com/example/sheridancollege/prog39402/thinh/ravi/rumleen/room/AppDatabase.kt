package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.common.Converters
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts.Cast
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts.CastDao
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesDao
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists.MyListDao
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists.MyLists
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows.TvShows
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows.TvShowsDao
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.User
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.UserDao
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.watchList.WatchList
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.watchList.WatchListDao

// AppDatabase.kt
@Database(entities = [User::class,
    Cast::class,Movies::class,
    MyLists::class,TvShows::class,
                     WatchList::class], version = 2)
@TypeConverters(Converters::class) // Add this line

abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun castDao(): CastDao
    abstract fun moviesDao(): MoviesDao
    abstract fun myListDao(): MyListDao
    abstract fun tvShowsDao(): TvShowsDao
    abstract fun watchListDao(): WatchListDao

    companion object{
        @Volatile
        var instance:AppDatabase?=null
        private const val DATABASE_NAME="myDb"

        fun getInstance(context: Context):AppDatabase?
        {
            if(instance == null)
            {
                synchronized(AppDatabase::class.java)
                {
                    if(instance == null)
                    {
                        instance= Room.databaseBuilder(context,AppDatabase::class.java,
                            DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }

            return instance
        }

    }
}
