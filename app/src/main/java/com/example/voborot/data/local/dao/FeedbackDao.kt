package com.example.voborot.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.voborot.data.local.dbModel.FeedbackDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FeedbackDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFeedback(feedback: FeedbackDbModel)

    @Update
    suspend fun updateFeedback(feedback: FeedbackDbModel)

    @Query("DELETE FROM feedbacks WHERE bookingId = :bookingId")
    suspend fun deleteFeedback(bookingId: Int)

    // отзывы для конкретного объявления
    @Query("""
        SELECT feedbacks.* FROM feedbacks
        INNER JOIN booking ON feedbacks.bookingId = booking.id
        WHERE booking.adId = :adId
    """)
    fun getFeedbacksForAd(adId: Int): Flow<List<FeedbackDbModel>>
}