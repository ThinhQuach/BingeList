package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.AppDatabase
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MyListRepository {

    companion object{
        var myDatabase: AppDatabase?=null

        private fun intialiseDB(context: Context): AppDatabase?
        {
            return AppDatabase.getInstance(context)!!
        }

        fun inserIntoMyList(context: Context,myList: MyLists)
        {
            myDatabase = intialiseDB(context)

            CoroutineScope(IO).launch{
                myDatabase!!.myListDao().insertToMyList(myList)
            }
        }


        fun getAllMyList(context: Context): LiveData<List<MyLists>>
        {
            myDatabase = intialiseDB(context)
            return myDatabase!!.myListDao().getMyList()
        }

        suspend fun deleteFromMyList(myList: MyLists) {
            CoroutineScope(IO).launch{
                myDatabase!!.myListDao().deleteFromMylit(myList)
            }
        }
        suspend fun deleteMyList(name: String) {
            CoroutineScope(IO).launch{
                myDatabase!!.myListDao().deleteMyList(name)
            }
        }

    }
}