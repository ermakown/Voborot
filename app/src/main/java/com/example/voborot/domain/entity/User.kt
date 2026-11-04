package com.example.voborot.domain.entity

data class User(
    val id: Int,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val userImage: String?,
    val email: String,
    val registrationDate: Long,
    val isConfirmed: Boolean
)
