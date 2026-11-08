package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "category",
    foreignKeys = [
        ForeignKey(
            entity = CategorySectionDbModel::class,
            parentColumns = ["id"],
            childColumns = ["categorySectionId"],
            onDelete = CASCADE
        )
    ]
)
data class CategoryDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val categorySectionId: Int
)
