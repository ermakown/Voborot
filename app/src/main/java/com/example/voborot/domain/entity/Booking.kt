package com.example.voborot.domain.entity

data class Booking(
    val id: Int,
    val startDate: Long,
    val endDate: Long,
    val bookingDate: Long,
    val count: Int,
    val renterId: Int,
    val decisionStatus: String,
    val adId: Int
)
