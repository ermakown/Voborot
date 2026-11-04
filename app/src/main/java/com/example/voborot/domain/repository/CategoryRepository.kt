package com.example.voborot.domain.repository

import com.example.voborot.domain.entity.AdCategory
import kotlinx.coroutines.flow.Flow


interface CategoryRepository {

    fun getAllCategories(): Flow<List<AdCategory>>
}