package com.example.voborot.domain.usecase.UserUseCase

import com.example.voborot.domain.entity.User
import com.example.voborot.domain.repository.UserRepository
import javax.inject.Inject

class EditUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        user: User
    ) {
        repository.editUser(user)
    }
}