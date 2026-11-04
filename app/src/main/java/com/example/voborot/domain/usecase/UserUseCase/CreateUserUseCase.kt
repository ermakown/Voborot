package com.example.voborot.domain.usecase.UserUseCase

import com.example.voborot.domain.repository.UserRepository
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        firstName: String,
        middleName: String?,
        lastName: String,
        userImage: String?,
        email: String,
        password: String
    ) {
        repository.createUser(
            firstName,
            middleName,
            lastName,
            userImage,
            email,
            password
        )
    }
}