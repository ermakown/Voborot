package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "photos",
    foreignKeys = [
        ForeignKey(
            entity = AdDbModel::class,
            parentColumns = ["id"],
            childColumns = ["adId"]
        )
    ]
)
data class PhotoDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val adId: Int,
    val path: String
)
