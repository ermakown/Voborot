package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.entity.Ad
import com.example.voborot.domain.repository.AdRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLessorAdsUseCase @Inject constructor(
    private val repository: AdRepository
) {

    operator fun invoke(
        lessorId: Int
    ): Flow<List<Ad>> {
        return repository.getLessorAds(lessorId)
    }
}