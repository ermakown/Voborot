package com.example.voborot.domain.usecase.BookingUseCase

import com.example.voborot.domain.entity.Booking
import com.example.voborot.domain.repository.BookingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserBookingsUseCase @Inject constructor(
    private val repository: BookingRepository
) {

    operator fun invoke(
        userId: Int
    ): Flow<List<Booking>> {
        return repository.getUserBookings(userId)
    }
}