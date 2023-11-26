package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts.Cast

@Entity(tableName = "mylist")
data class MyLists (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val image: String,
    val isChildren: String,
    val director_name: String,
    val director_image: String,
    val trailor_link: String,
    val total_time: String,
    val rating: String,
    val isInMyList: String,
    val isWatched: String,
  /*  @Relation(
        parentColumn = "id",
        entityColumn = "showId"
    )*/
    val casts: List<Cast>,
    val user_review: String,
    val user_score: String,
    val movieId: String,
    val tvShowId: String,
    val type: String
)

