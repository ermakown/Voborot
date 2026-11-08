package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "category section"
)
data class CategorySectionDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)
