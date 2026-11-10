package com.example.voborot.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.voborot.data.local.dbModel.BookingDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface BookingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooking(booking: BookingDbModel)

    @Query("SELECT * FROM booking WHERE id = :bookingId LIMIT 1")
    suspend fun getBookingById(bookingId: Int): BookingDbModel?

    @Query("UPDATE booking SET decisionStatus = :status WHERE id = :bookingId")
    suspend fun updateDecisionStatus(bookingId: Int, status: String)

    @Query("UPDATE booking SET endDate = :currentTimeMillis WHERE id = :bookingId")
    suspend fun completeBookingEarly(bookingId: Int, currentTimeMillis: Long)

    @Query("DELETE FROM booking WHERE id = :bookingId")
    suspend fun deleteBooking(bookingId: Int)

    // История: как те сделки, где юзер берет вещь, так и те, где сдает свою
    @Query("""
        SELECT * FROM booking 
        WHERE renterId = :userId 
        OR adId IN (SELECT id FROM ads WHERE lessorId = :userId)
        ORDER BY bookingDate DESC
    """)
    fun getUserBookings(userId: Int): Flow<List<BookingDbModel>>
}