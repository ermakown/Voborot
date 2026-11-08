package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "favorites",
    primaryKeys = ["userId", "adId"],
    foreignKeys = [
        ForeignKey(
            entity = UserDbModel::class,
            parentColumns = ["id"],
            childColumns = ["userId"]
        ),
        ForeignKey(
            entity = AdDbModel::class,
            parentColumns = ["id"],
            childColumns = ["adId"]
        )
    ]
)
data class FavoritesDbModel(
    val userId: Int,
    val adId: Int
)
