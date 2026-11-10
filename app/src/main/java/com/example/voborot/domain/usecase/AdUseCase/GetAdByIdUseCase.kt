package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.entity.Ad
import com.example.voborot.domain.repository.AdRepository
import javax.inject.Inject

class GetAdByIdUseCase @Inject constructor(
    private val repository: AdRepository
) {

    suspend operator fun invoke(
        adId: Int
    ): Ad? {
        return repository.getAdById(adId)
    }
}