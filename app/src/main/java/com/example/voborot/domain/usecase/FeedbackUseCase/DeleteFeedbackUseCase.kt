package com.example.voborot.domain.usecase.FeedbackUseCase

import com.example.voborot.domain.repository.FeedbackRepository
import javax.inject.Inject

class DeleteFeedbackUseCase @Inject constructor(
    private val repository: FeedbackRepository
) {

    suspend operator fun invoke(
        bookingId: Int
    ) {
        repository.deleteFeedback(bookingId)
    }
}