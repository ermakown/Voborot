package com.example.voborot.domain.repository

import com.example.voborot.domain.entity.Ad
import kotlinx.coroutines.flow.Flow

interface AdRepository {

    suspend fun createAd(
        lessorId: Int,
        name: String,
        description: String,
        categoryId: Int,
        totalNumber: Int,
        rentalCostPerHour: Int,
        rentalCostPerDay: Int,
        collateral: Int, // залог
        address: String,
        availableFromHour: Int,
        availableToHour: Int,
        isAvailable: Boolean,
        photos: List<String>
    )

    suspend fun editAd(ad: Ad)

    suspend fun deleteAd(adId: Int)

    suspend fun getAdById(adId: Int): Ad?

    fun getFilteredAds(
        query: String?,
        categoryId: Int?,
        minPrice: Int?,
        maxPrice: Int?
    ): Flow<List<Ad>>

    suspend fun toggleFavorite(userId: Int, adId: Int)

    fun getFavouriteAds(userId: Int): Flow<List<Ad>>

    // просмотр моих объявлений как арендодатель
    fun getLessorAds(lessorId: Int): Flow<List<Ad>>

}