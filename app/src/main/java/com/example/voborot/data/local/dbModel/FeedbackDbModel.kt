package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "feedbacks",
    foreignKeys = [
        ForeignKey(
            entity = BookingDbModel::class,
            parentColumns = ["id"],
            childColumns = ["bookingId"],
            onDelete = CASCADE
        )
    ]
)
data class FeedbackDbModel(
    @PrimaryKey
    val bookingId: Int,
    val mark: Int,
    val text: String?,
    val date: Long
)
