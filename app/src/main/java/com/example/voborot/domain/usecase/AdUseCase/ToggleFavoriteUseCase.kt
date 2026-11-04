package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.repository.AdRepository
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val repository: AdRepository
) {

    suspend operator fun invoke(
        userId: Int,
        adId: Int
    ) {
        repository.toggleFavorite(userId, adId)
    }
}