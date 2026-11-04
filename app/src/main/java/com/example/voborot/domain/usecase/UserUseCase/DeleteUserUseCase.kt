package com.example.voborot.domain.usecase.UserUseCase

import com.example.voborot.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        userId: Int
    ) {
        repository.deleteUser(userId)
    }
}