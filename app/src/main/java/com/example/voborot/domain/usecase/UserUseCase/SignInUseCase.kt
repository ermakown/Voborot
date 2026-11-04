package com.example.voborot.domain.usecase.UserUseCase

import com.example.voborot.domain.entity.User
import com.example.voborot.domain.repository.UserRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        email: String,
        password: String
    ): User {
        return repository.signIn(email, password)
    }
}