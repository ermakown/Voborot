package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.entity.Ad
import com.example.voborot.domain.repository.AdRepository
import javax.inject.Inject

class EditAdUseCase @Inject constructor(
    private val repository: AdRepository
) {

    suspend operator fun invoke(
        ad: Ad
    ) {
        repository.editAd(ad)
    }
}