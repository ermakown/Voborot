package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "users"
)
data class UserDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val userImage: String?,
    val email: String,
    val registrationDate: Long,
    val isConfirmed: Boolean
)