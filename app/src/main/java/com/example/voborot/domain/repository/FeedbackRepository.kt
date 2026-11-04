package com.example.voborot.domain.repository

import com.example.voborot.domain.entity.Feedback
import kotlinx.coroutines.flow.Flow

interface FeedbackRepository {

    suspend fun createFeedback(
        bookingId: Int,
        mark: Int,
        text: String?
    )

    suspend fun deleteFeedback(
        bookingId: Int
    )

    suspend fun editFeedback(
        feedback: Feedback
    )

    fun getAllFeedbacks(
        adId: Int
    ): Flow<List<Feedback>>
}