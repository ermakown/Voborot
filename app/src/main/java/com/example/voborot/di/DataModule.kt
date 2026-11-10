package com.example.voborot.di

import android.content.Context
import androidx.room.Room
import com.example.voborot.data.local.VoborotDatabase
import com.example.voborot.data.local.dao.AdDao
import com.example.voborot.data.local.dao.BookingDao
import com.example.voborot.data.local.dao.CategoryDao
import com.example.voborot.data.local.dao.FeedbackDao
import com.example.voborot.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule{

    companion object {

        @Provides
        @Singleton
        fun provideVoborotDatabase(
            @ApplicationContext context: Context
        ): VoborotDatabase {

            return Room.databaseBuilder(
                context = context,
                klass = VoborotDatabase::class.java,
                name = "voborot.db"
            ).fallbackToDestructiveMigration(dropAllTables = true).build()
        }

        @Provides
        @Singleton
        fun provideCategoryDao(
            database: VoborotDatabase
        ): CategoryDao = database.categoryDao()

        @Provides
        @Singleton
        fun provideAdDao(
            database: VoborotDatabase
        ): AdDao = database.adDao()

        @Provides
        @Singleton
        fun provideUserDao(
            database: VoborotDatabase
        ): UserDao = database.userDao()

        @Provides
        @Singleton
        fun provideBookingDao(
            database: VoborotDatabase
        ): BookingDao = database.bookingDao()

        @Provides
        @Singleton
        fun provideFeedbackDao(
            database: VoborotDatabase
        ): FeedbackDao = database.feedbackDao()
    }
}