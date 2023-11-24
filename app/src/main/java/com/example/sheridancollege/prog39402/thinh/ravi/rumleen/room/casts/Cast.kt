package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "casts")
data class Cast(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val image: String,
    val role_name: String,
)
