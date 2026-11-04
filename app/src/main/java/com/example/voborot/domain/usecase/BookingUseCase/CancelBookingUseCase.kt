package com.example.voborot.domain.usecase.BookingUseCase

import com.example.voborot.domain.repository.BookingRepository
import javax.inject.Inject

class CancelBookingUseCase @Inject constructor(
    private val repository: BookingRepository
) {

    suspend operator fun invoke(
        bookingId: Int
    ) {
        repository.cancelBooking(bookingId)
    }
}