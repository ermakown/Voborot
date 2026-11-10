package com.example.voborot.data.local.dao.feedback

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

    // Джоиним с таблицей бронирований, чтобы вытащить отзывы для конкретного объявления
    @Query("""
        SELECT f.* FROM feedbacks f
        INNER JOIN booking b ON f.bookingId = b.id
        WHERE b.adId = :adId
    """)
    fun getFeedbacksForAd(adId: Int): Flow<List<FeedbackDbModel>>
}