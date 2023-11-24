package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts.Cast

@Entity(tableName = "movies")
data class Movies(
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
    val description: String,
  /*  @Relation(
        parentColumn = "id",
        entityColumn = "showId"
    )*/
    val casts: List<Cast>,
)
