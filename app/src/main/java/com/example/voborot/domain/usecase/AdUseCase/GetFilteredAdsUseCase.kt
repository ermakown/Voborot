package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.entity.Ad
import com.example.voborot.domain.repository.AdRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFilteredAdsUseCase @Inject constructor(
    private val repository: AdRepository
) {

    operator fun invoke(
        query: String?,
        categoryId: Int?,
        minPrice: Int?,
        maxPrice: Int?
    ): Flow<List<Ad>> {
        return repository.getFilteredAds(
            query,
            categoryId,
            minPrice,
            maxPrice
        )
    }
}