package com.example.voborot.domain.usecase.FeedbackUseCase

import com.example.voborot.domain.entity.Feedback
import com.example.voborot.domain.repository.FeedbackRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFeedbacksUseCase @Inject constructor(
    private val repository: FeedbackRepository
) {

    operator fun invoke(
        adId: Int
    ): Flow<List<Feedback>> {
        return repository.getAllFeedbacks(adId)
    }
}