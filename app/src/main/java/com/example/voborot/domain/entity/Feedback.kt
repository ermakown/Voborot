package com.example.voborot.domain.entity

data class Feedback(
    val bookingId: Int,
    val mark: Int,
    val text: String?,
    val date: Long
)
