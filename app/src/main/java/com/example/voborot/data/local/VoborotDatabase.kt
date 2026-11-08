package com.example.voborot.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.voborot.data.local.dbModel.AdDbModel
import com.example.voborot.data.local.dbModel.BookingDbModel
import com.example.voborot.data.local.dbModel.CategoryDbModel
import com.example.voborot.data.local.dbModel.CategorySectionDbModel
import com.example.voborot.data.local.dbModel.FavoritesDbModel
import com.example.voborot.data.local.dbModel.FeedbackDbModel
import com.example.voborot.data.local.dbModel.PhotoDbModel
import com.example.voborot.data.local.dbModel.UserDbModel

@Database(
    entities = [
        AdDbModel::class,
        BookingDbModel::class,
        CategoryDbModel::class,
        CategorySectionDbModel::class,
        FavoritesDbModel::class,
        FeedbackDbModel::class,
        PhotoDbModel::class,
        UserDbModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class VoborotDatabase: RoomDatabase() {

}
