package com.example.voborot.domain.repository

import com.example.voborot.domain.entity.Booking
import kotlinx.coroutines.flow.Flow

interface BookingRepository {

    suspend fun createBooking(
        adId: Int,
        renterId: Int,
        startDate: Long,
        endDate: Long,
        count: Int
    )

    // отмена бронирования
    suspend fun cancelBooking(bookingId: Int)

    suspend fun getBookingById(bookingId: Int): Booking?

    fun getUserBookings(userId: Int): Flow<List<Booking>>

    // подтверждение бронирования
    suspend fun bookingConfirmation(bookingId: Int)

    suspend fun earlyTerminationBooking(
        bookingId: Int
    )

    suspend fun deleteBooking(bookingId: Int)
}