package com.example.voborot.data.local.dbModel

import androidx.room.Embedded
import androidx.room.Relation
import com.example.voborot.domain.entity.Ad

data class AdWithPhotosDbModel(
    @Embedded val ad: Ad,
    @Relation(
        parentColumn = "id",
        entityColumn = "adId"
    )
    val photos: List<PhotoDbModel>
    )
