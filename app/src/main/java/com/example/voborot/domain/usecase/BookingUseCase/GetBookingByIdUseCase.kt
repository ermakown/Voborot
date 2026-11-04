package com.example.voborot.domain.usecase.BookingUseCase

import com.example.voborot.domain.entity.Booking
import com.example.voborot.domain.repository.BookingRepository
import javax.inject.Inject

class GetBookingByIdUseCase @Inject constructor(
    private val repository: BookingRepository
) {

    suspend operator fun invoke(
        bookingId: Int
    ): Booking {
        return repository.getBookingById(bookingId)
    }
}