package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "ads",
    foreignKeys = [
        ForeignKey(
            entity = UserDbModel::class,
            parentColumns = ["id"],
            childColumns = ["lessorId"]
        ),
        ForeignKey(
            entity = CategoryDbModel::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"]
        )
    ],
    indices = [Index("lessorId"), Index("categoryId")]
)
data class AdDbModel(
    @PrimaryKey(autoGenerate = true)
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
    val availableFromHour: Int,
    val availableToHour: Int,
    val isAvailable: Boolean
)
