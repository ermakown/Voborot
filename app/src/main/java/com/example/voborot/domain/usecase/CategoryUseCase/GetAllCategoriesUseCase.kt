package com.example.voborot.domain.usecase.CategoryUseCase

import com.example.voborot.domain.entity.AdCategory
import com.example.voborot.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val repository: CategoryRepository
) {

    operator fun invoke(): Flow<List<AdCategory>> {
        return repository.getAllCategories()
    }
}