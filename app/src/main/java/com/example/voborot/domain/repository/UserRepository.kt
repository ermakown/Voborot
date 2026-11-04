package com.example.voborot.domain.repository

import com.example.voborot.domain.entity.User

interface UserRepository {

    suspend fun createUser(
        firstName: String,
        middleName: String?,
        lastName: String,
        userImage: String?,
        email: String,
        password: String
    )

    suspend fun editUser(user: User)

    suspend fun deleteUser(userId: Int)

    suspend fun getUser(userId: Int): User

    suspend fun signIn(email: String, password: String): User

    suspend fun getCurrentUser(): User? // для проверки активности текущей сессии
}