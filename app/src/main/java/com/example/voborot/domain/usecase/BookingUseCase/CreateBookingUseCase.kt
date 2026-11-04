package com.example.voborot.domain.usecase.BookingUseCase

import com.example.voborot.domain.repository.BookingRepository
import javax.inject.Inject

class CreateBookingUseCase @Inject constructor(
    private val repository: BookingRepository
) {

    suspend operator fun invoke(
        adId: Int,
        renterId: Int,
        startDate: Long,
        endDate: Long,
        count: Int
    ) {
        repository.createBooking(
            adId,
            renterId,
            startDate,
            endDate,
            count
        )
    }
}