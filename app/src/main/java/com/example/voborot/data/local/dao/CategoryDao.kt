package com.example.voborot.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.voborot.data.local.dbModel.CategoryDbModel
import com.example.voborot.data.local.dbModel.CategorySectionDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSections(sections: List<CategorySectionDbModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<CategoryDbModel>)

    @Query("SELECT * FROM category")
    fun getAllCategories(): Flow<List<CategoryDbModel>>
}