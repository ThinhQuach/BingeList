package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val email: String,
    val password: String,
    val isChildren: String,
    val contactNumber: String,
    val address: String,
    val dob: String,
)
