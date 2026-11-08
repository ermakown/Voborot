package com.example.voborot.di

import android.content.Context
import androidx.room.Room
import com.example.voborot.data.local.VoborotDatabase
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
    }
}