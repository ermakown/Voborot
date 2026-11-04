package com.example.voborot.domain.usecase.FeedbackUseCase

import com.example.voborot.domain.repository.FeedbackRepository
import javax.inject.Inject

class CreateFeedbackUseCase @Inject constructor(
    private val repository: FeedbackRepository
) {

    suspend operator fun invoke(
        bookingId: Int,
        mark: Int,
        text: String?
    ) {
        repository.createFeedback(bookingId, mark, text)
    }
}