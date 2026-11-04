package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.repository.AdRepository
import javax.inject.Inject

class DeleteAdUseCase @Inject constructor(
    private val repository: AdRepository
) {

    suspend operator fun invoke(
        adId: Int
    ) {
        repository.deleteAd(adId)
    }
}