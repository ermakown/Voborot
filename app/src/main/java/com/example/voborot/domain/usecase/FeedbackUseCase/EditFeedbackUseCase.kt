package com.example.voborot.domain.usecase.FeedbackUseCase

import com.example.voborot.domain.entity.Feedback
import com.example.voborot.domain.repository.FeedbackRepository
import javax.inject.Inject

class EditFeedbackUseCase @Inject constructor(
    private val repository: FeedbackRepository
) {

    suspend operator fun invoke(
        feedback: Feedback
    ) {
        repository.editFeedback(feedback)
    }
}