package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.repository.AdRepository
import javax.inject.Inject

class CreateAdUseCase @Inject constructor(
    private val repository: AdRepository
) {

    suspend operator fun invoke(
        lessorId: Int,
        name: String,
        description: String,
        categoryId: Int,
        totalNumber: Int,
        rentalCostPerHour: Int,
        rentalCostPerDay: Int,
        collateral: Int,
        address: String,
        availableFromHour: Int,
        availableToHour: Int,
        isAvailable: Boolean,
        photos: List<String>
    ) {
        repository.createAd(
            lessorId,
            name,
            description,
            categoryId,
            totalNumber,
            rentalCostPerHour,
            rentalCostPerDay,
            collateral,
            address,
            availableFromHour,
            availableToHour,
            isAvailable,
            photos
        )
    }
}