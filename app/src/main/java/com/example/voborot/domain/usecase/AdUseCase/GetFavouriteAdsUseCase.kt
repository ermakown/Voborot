package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.entity.Ad
import com.example.voborot.domain.repository.AdRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouriteAdsUseCase @Inject constructor(
    private val repository: AdRepository
) {

    operator fun invoke(
        userId: Int
    ): Flow<List<Ad>> {
        return repository.getFavouriteAds(userId)
    }
}