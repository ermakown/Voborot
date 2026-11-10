package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "booking",
    foreignKeys = [
        ForeignKey(
            entity = AdDbModel::class,
            parentColumns = ["id"],
            childColumns = ["adId"]
        ),
        ForeignKey(
            entity = UserDbModel::class,
            parentColumns = ["id"],
            childColumns = ["renterId"]
        )
    ],
    indices = [Index("renterId"), Index("adId")]
)
data class BookingDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val startDate: Long,
    val endDate: Long,
    val bookingDate: Long,
    val count: Int,
    val renterId: Int,
    val decisionStatus: String,
    val adId: Int
)
