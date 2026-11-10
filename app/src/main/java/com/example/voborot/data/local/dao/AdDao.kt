package com.example.voborot.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.voborot.data.local.dbModel.AdDbModel
import com.example.voborot.data.local.dbModel.AdWithPhotosDbModel
import com.example.voborot.data.local.dbModel.FavoritesDbModel
import com.example.voborot.data.local.dbModel.PhotoDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AdDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAd(ad: AdDbModel): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(photos: List<PhotoDbModel>)

    @Update
    suspend fun updateAd(ad: AdDbModel)

    @Query("DELETE FROM ads WHERE id = :adId")
    suspend fun deleteAd(adId: Int)

    @Transaction
    @Query("SELECT * FROM ads WHERE id = :adId LIMIT 1")
    suspend fun getAdById(adId: Int): AdWithPhotosDbModel?

    @Transaction
    @Query("""
        SELECT * FROM ads 
        WHERE (:query IS NULL OR name LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%')
        AND (:categoryId IS NULL OR categoryId = :categoryId)
        AND (:minPrice IS NULL OR rentalCostPerDay >= :minPrice)
        AND (:maxPrice IS NULL OR rentalCostPerDay <= :maxPrice)
        AND isAvailable = 1
        ORDER BY publicationDate DESC
    """)
    fun getFilteredAds(
        query: String?,
        categoryId: Int?,
        minPrice: Int?,
        maxPrice: Int?
    ): Flow<List<AdWithPhotosDbModel>>

    @Transaction
    @Query("SELECT * FROM ads WHERE lessorId = :lessorId ORDER BY publicationDate DESC")
    fun getLessorAds(lessorId: Int): Flow<List<AdWithPhotosDbModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavorite(favorite: FavoritesDbModel)

    @Query("DELETE FROM favorites WHERE userId = :userId AND adId = :adId")
    suspend fun deleteFavorite(userId: Int, adId: Int)

    @Transaction
    @Query("""
        SELECT ads.* FROM ads
        INNER JOIN favorites ON ads.id = favorites.adId
        WHERE favorites.userId = :userId
    """)
    fun getFavoriteAds(userId: Int): Flow<List<AdWithPhotosDbModel>>
}