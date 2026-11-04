package com.example.voborot.domain.entity

data class Ad(
    val id: Int,
    val lessorId: Int,
    val categoryId: Int,
    val name: String,
    val description: String,
    val totalNumber: Int,
    val rentalCostPerHour: Int,
    val rentalCostPerDay: Int,
    val collateral: Int, // залог
    val address: String,
    val publicationDate: Long,
    val lastModifiedDate: Long,
    val availableHours: String,
    val isAvailable: Boolean,
    val photos: List<String>
)
