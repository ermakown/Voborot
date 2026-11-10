# Project Voborot Codebase

## Project File Tree

```text
📄 build.gradle.kts
📄 gradle.properties
📄 settings.gradle.kts
📁 app/
  📄 build.gradle.kts
  📁 src/
    📁 androidTest/
      📁 java/
        📁 com/
          📁 example/
            📁 voborot/
              📄 ExampleInstrumentedTest.kt
    📁 main/
      📄 AndroidManifest.xml
      📁 java/
        📁 com/
          📁 example/
            📁 voborot/
              📄 VoborotApp.kt
              📁 data/
                📁 local/
                  📄 VoborotDatabase.kt
                  📁 dbModel/
                    📄 AdDbModel.kt
                    📄 AdWithPhotosDbModel.kt
                    📄 BookingDbModel.kt
                    📄 CategoryDbModel.kt
                    📄 CategorySectionDbModel.kt
                    📄 FavoritesDbModel.kt
                    📄 FeedbackDbModel.kt
                    📄 PhotoDbModel.kt
                    📄 UserDbModel.kt
              📁 di/
                📄 DataModule.kt
              📁 domain/
                📁 entity/
                  📄 Ad.kt
                  📄 AdCategory.kt
                  📄 Booking.kt
                  📄 Feedback.kt
                  📄 User.kt
                📁 repository/
                  📄 AdRepository.kt
                  📄 BookingRepository.kt
                  📄 CategoryRepository.kt
                  📄 FeedbackRepository.kt
                  📄 UserRepository.kt
                📁 usecase/
                  📁 AdUseCase/
                    📄 CreateAdUseCase.kt
                    📄 DeleteAdUseCase.kt
                    📄 EditAdUseCase.kt
                    📄 GetAdByIdUseCase.kt
                    📄 GetFavouriteAdsUseCase.kt
                    📄 GetFilteredAdsUseCase.kt
                    📄 GetLessorAdsUseCase.kt
                    📄 ToggleFavoriteUseCase.kt
                  📁 BookingUseCase/
                    📄 BookingConfirmationUseCase.kt
                    📄 CancelBookingUseCase.kt
                    📄 CreateBookingUseCase.kt
                    📄 DeleteBookingUseCase.kt
                    📄 EarlyTerminationBookingUseCase.kt
                    📄 GetBookingByIdUseCase.kt
                    📄 GetUserBookingsUseCase.kt
                  📁 CategoryUseCase/
                    📄 GetAllCategoriesUseCase.kt
                  📁 FeedbackUseCase/
                    📄 CreateFeedbackUseCase.kt
                    📄 DeleteFeedbackUseCase.kt
                    📄 EditFeedbackUseCase.kt
                    📄 GetAllFeedbacksUseCase.kt
                  📁 UserUseCase/
                    📄 CreateUserUseCase.kt
                    📄 DeleteUserUseCase.kt
                    📄 EditUserUseCase.kt
                    📄 GetCurrentUserUseCase.kt
                    📄 GetUserUseCase.kt
                    📄 SignInUseCase.kt
              📁 presentation/
                📄 MainActivity.kt
                📁 ui/
                  📁 theme/
                    📄 Color.kt
                    📄 Theme.kt
                    📄 Type.kt
      📁 keepRules/
      📁 res/
        📁 drawable/
        📁 mipmap-anydpi-v26/
        📁 mipmap-hdpi/
        📁 mipmap-mdpi/
        📁 mipmap-xhdpi/
        📁 mipmap-xxhdpi/
        📁 mipmap-xxxhdpi/
        📁 values/
          📄 colors.xml
          📄 strings.xml
          📄 themes.xml
        📁 xml/
          📄 backup_rules.xml
          📄 data_extraction_rules.xml
    📁 test/
      📁 java/
        📁 com/
          📁 example/
            📁 voborot/
              📄 ExampleUnitTest.kt
📁 gradle/
  📄 gradle-daemon-jvm.properties
  📄 libs.versions.toml
  📁 wrapper/
    📄 gradle-wrapper.properties
```

---

## Source Code

### File: `build.gradle.kts`

````kotlin
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlin.serialization) apply false
}
````

---

### File: `gradle.properties`

````properties
# Project-wide Gradle settings.
# IDE (e.g. Android Studio) users:
# Gradle settings configured through the IDE *will override*
# any settings specified in this file.
# For more details on how to configure your build environment visit
# http://www.gradle.org/docs/current/userguide/build_environment.html
# Specifies the JVM arguments used for the daemon process.
# The setting is particularly useful for tweaking memory settings.
org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
# When configured, Gradle will run in incubating parallel mode.
# This option should only be used with decoupled projects. For more details, visit
# https://developer.android.com/r/tools/gradle-multi-project-decoupled-projects
# org.gradle.parallel=true
# When enabled, the Configuration Cache allows Gradle to skip the configuration
# phase entirely if nothing that affects the build configuration (such as build scripts)
# has changed. Additionally, Gradle applies performance optimizations to task execution.
org.gradle.configuration-cache=true
# Kotlin code style for this project: "official" or "obsolete":
kotlin.code.style=official
````

---

### File: `settings.gradle.kts`

````kotlin
pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Voborot"
include(":app")
````

---

### File: `app/build.gradle.kts`

````kotlin
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.voborot"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.voborot"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.navigation.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.room.runtime)
    implementation(libs.kotlinx.serialization.json)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.hilt.android)
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    ksp(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}
````

---

### File: `app/src/androidTest/java/com/example/voborot/ExampleInstrumentedTest.kt`

````kotlin
package com.example.voborot

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.voborot", appContext.packageName)
    }
}
````

---

### File: `app/src/main/AndroidManifest.xml`

````xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:name=".VoborotApp"
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Voborot">
        <activity
            android:name=".presentation.MainActivity"
            android:exported="true"
            android:label="@string/app_name"
            android:theme="@style/Theme.Voborot"
            android:windowSoftInputMode="adjustResize">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
````

---

### File: `app/src/main/java/com/example/voborot/VoborotApp.kt`

````kotlin
package com.example.voborot

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class VoborotApp: Application()
````

---

### File: `app/src/main/java/com/example/voborot/data/local/VoborotDatabase.kt`

````kotlin
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
````

---

### File: `app/src/main/java/com/example/voborot/data/local/dbModel/AdDbModel.kt`

````kotlin
package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ads",
    foreignKeys = [
        ForeignKey(
            entity = UserDbModel::class,
            parentColumns = ["id"],
            childColumns = ["lessorId"]
        ),
        ForeignKey(
            entity = CategoryDbModel::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"]
        )
    ]
)
data class AdDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val lessorId: Int,
    val categoryId: Int,
    val name: String,
    val description: String,
    val totalNumber: Int,
    val rentalCostPerHour: Int,
    val rentalCostPerDay: Int,
    val collateral: Int, // залог
    val address: String,
    val publicationDate: Long,
    val lastModifiedDate: Long,
    val availableFromHour: Int,
    val availableToHour: Int,
    val isAvailable: Boolean
)
````

---

### File: `app/src/main/java/com/example/voborot/data/local/dbModel/AdWithPhotosDbModel.kt`

````kotlin
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
````

---

### File: `app/src/main/java/com/example/voborot/data/local/dbModel/BookingDbModel.kt`

````kotlin
package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "booking",
    foreignKeys = [
        ForeignKey(
            entity = AdDbModel::class,
            parentColumns = ["id"],
            childColumns = ["adId"]
        ),
        ForeignKey(
            entity = UserDbModel::class,
            parentColumns = ["id"],
            childColumns = ["renterId"]
        )
    ]
)
data class BookingDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val startDate: Long,
    val endDate: Long,
    val bookingDate: Long,
    val count: Int,
    val renterId: Int,
    val decisionStatus: String,
    val adId: Int
)
````

---

### File: `app/src/main/java/com/example/voborot/data/local/dbModel/CategoryDbModel.kt`

````kotlin
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
````

---

### File: `app/src/main/java/com/example/voborot/data/local/dbModel/CategorySectionDbModel.kt`

````kotlin
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
````

---

### File: `app/src/main/java/com/example/voborot/data/local/dbModel/FavoritesDbModel.kt`

````kotlin
package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "favorites",
    primaryKeys = ["userId", "adId"],
    foreignKeys = [
        ForeignKey(
            entity = UserDbModel::class,
            parentColumns = ["id"],
            childColumns = ["userId"]
        ),
        ForeignKey(
            entity = AdDbModel::class,
            parentColumns = ["id"],
            childColumns = ["adId"]
        )
    ]
)
data class FavoritesDbModel(
    val userId: Int,
    val adId: Int
)
````

---

### File: `app/src/main/java/com/example/voborot/data/local/dbModel/FeedbackDbModel.kt`

````kotlin
package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "feedbacks",
    foreignKeys = [
        ForeignKey(
            entity = BookingDbModel::class,
            parentColumns = ["id"],
            childColumns = ["bookingId"],
            onDelete = CASCADE
        )
    ]
)
data class FeedbackDbModel(
    @PrimaryKey
    val bookingId: Int,
    val mark: Int,
    val text: String?,
    val date: Long
)
````

---

### File: `app/src/main/java/com/example/voborot/data/local/dbModel/PhotoDbModel.kt`

````kotlin
package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "photos",
    foreignKeys = [
        ForeignKey(
            entity = AdDbModel::class,
            parentColumns = ["id"],
            childColumns = ["adId"]
        )
    ]
)
data class PhotoDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val adId: Int,
    val path: String
)
````

---

### File: `app/src/main/java/com/example/voborot/data/local/dbModel/UserDbModel.kt`

````kotlin
package com.example.voborot.data.local.dbModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "users"
)
data class UserDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val userImage: String?,
    val email: String,
    val registrationDate: Long,
    val isConfirmed: Boolean
)
````

---

### File: `app/src/main/java/com/example/voborot/di/DataModule.kt`

````kotlin
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
````

---

### File: `app/src/main/java/com/example/voborot/domain/entity/Ad.kt`

````kotlin
package com.example.voborot.domain.entity

data class Ad(
    val id: Int,
    val lessorId: Int,
    val categoryId: Int,
    val name: String,
    val description: String,
    val totalNumber: Int,
    val rentalCostPerHour: Int,
    val rentalCostPerDay: Int,
    val collateral: Int, // залог
    val address: String,
    val publicationDate: Long,
    val lastModifiedDate: Long,
    val availableFromHour: Int,
    val availableToHour: Int,
    val isAvailable: Boolean,
    val photos: List<String>
)
````

---

### File: `app/src/main/java/com/example/voborot/domain/entity/AdCategory.kt`

````kotlin
package com.example.voborot.domain.entity

data class AdCategory(
    val id: Int,
    val name: String,
    val sectionId: Int
)
````

---

### File: `app/src/main/java/com/example/voborot/domain/entity/Booking.kt`

````kotlin
package com.example.voborot.domain.entity

data class Booking(
    val id: Int,
    val startDate: Long,
    val endDate: Long,
    val bookingDate: Long,
    val count: Int,
    val renterId: Int,
    val decisionStatus: String,
    val adId: Int
)
````

---

### File: `app/src/main/java/com/example/voborot/domain/entity/Feedback.kt`

````kotlin
package com.example.voborot.domain.entity

data class Feedback(
    val bookingId: Int,
    val mark: Int,
    val text: String?,
    val date: Long
)
````

---

### File: `app/src/main/java/com/example/voborot/domain/entity/User.kt`

````kotlin
package com.example.voborot.domain.entity

data class User(
    val id: Int,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val userImage: String?,
    val email: String,
    val registrationDate: Long,
    val isConfirmed: Boolean
)
````

---

### File: `app/src/main/java/com/example/voborot/domain/repository/AdRepository.kt`

````kotlin
package com.example.voborot.domain.repository

import com.example.voborot.domain.entity.Ad
import kotlinx.coroutines.flow.Flow

interface AdRepository {

    suspend fun createAd(
        lessorId: Int,
        name: String,
        description: String,
        categoryId: Int,
        totalNumber: Int,
        rentalCostPerHour: Int,
        rentalCostPerDay: Int,
        collateral: Int, // залог
        address: String,
        availableFromHour: Int,
        availableToHour: Int,
        isAvailable: Boolean,
        photos: List<String>
    )

    suspend fun editAd(ad: Ad)

    suspend fun deleteAd(adId: Int)

    suspend fun getAdById(adId: Int): Ad

    fun getFilteredAds(
        query: String?,
        categoryId: Int?,
        minPrice: Int?,
        maxPrice: Int?
    ): Flow<List<Ad>>

    suspend fun toggleFavorite(userId: Int, adId: Int)

    fun getFavouriteAds(userId: Int): Flow<List<Ad>>

    // просмотр моих объявлений как арендодатель
    fun getLessorAds(lessorId: Int): Flow<List<Ad>>

}
````

---

### File: `app/src/main/java/com/example/voborot/domain/repository/BookingRepository.kt`

````kotlin
package com.example.voborot.domain.repository

import com.example.voborot.domain.entity.Booking
import kotlinx.coroutines.flow.Flow

interface BookingRepository {

    suspend fun createBooking(
        adId: Int,
        renterId: Int,
        startDate: Long,
        endDate: Long,
        count: Int
    )

    // отмена бронирования
    suspend fun cancelBooking(bookingId: Int)

    suspend fun getBookingById(bookingId: Int): Booking

    fun getUserBookings(userId: Int): Flow<List<Booking>>

    // подтверждение бронирования
    suspend fun bookingConfirmation(bookingId: Int)

    suspend fun earlyTerminationBooking(
        bookingId: Int
    )

    suspend fun deleteBooking(bookingId: Int)
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/repository/CategoryRepository.kt`

````kotlin
package com.example.voborot.domain.repository

import com.example.voborot.domain.entity.AdCategory
import kotlinx.coroutines.flow.Flow


interface CategoryRepository {

    fun getAllCategories(): Flow<List<AdCategory>>
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/repository/FeedbackRepository.kt`

````kotlin
package com.example.voborot.domain.repository

import com.example.voborot.domain.entity.Feedback
import kotlinx.coroutines.flow.Flow

interface FeedbackRepository {

    suspend fun createFeedback(
        bookingId: Int,
        mark: Int,
        text: String?
    )

    suspend fun deleteFeedback(
        bookingId: Int
    )

    suspend fun editFeedback(
        feedback: Feedback
    )

    fun getAllFeedbacks(
        adId: Int
    ): Flow<List<Feedback>>
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/repository/UserRepository.kt`

````kotlin
package com.example.voborot.domain.repository

import com.example.voborot.domain.entity.User

interface UserRepository {

    suspend fun createUser(
        firstName: String,
        middleName: String?,
        lastName: String,
        userImage: String?,
        email: String,
        password: String
    )

    suspend fun editUser(user: User)

    suspend fun deleteUser(userId: Int)

    suspend fun getUser(userId: Int): User

    suspend fun signIn(email: String, password: String): User

    suspend fun getCurrentUser(): User? // для проверки активности текущей сессии
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/AdUseCase/CreateAdUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.repository.AdRepository
import javax.inject.Inject

class CreateAdUseCase @Inject constructor(
    private val repository: AdRepository
) {

    suspend operator fun invoke(
        lessorId: Int,
        name: String,
        description: String,
        categoryId: Int,
        totalNumber: Int,
        rentalCostPerHour: Int,
        rentalCostPerDay: Int,
        collateral: Int,
        address: String,
        availableFromHour: Int,
        availableToHour: Int,
        isAvailable: Boolean,
        photos: List<String>
    ) {
        repository.createAd(
            lessorId,
            name,
            description,
            categoryId,
            totalNumber,
            rentalCostPerHour,
            rentalCostPerDay,
            collateral,
            address,
            availableFromHour,
            availableToHour,
            isAvailable,
            photos
        )
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/AdUseCase/DeleteAdUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.repository.AdRepository
import javax.inject.Inject

class DeleteAdUseCase @Inject constructor(
    private val repository: AdRepository
) {

    suspend operator fun invoke(
        adId: Int
    ) {
        repository.deleteAd(adId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/AdUseCase/EditAdUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.entity.Ad
import com.example.voborot.domain.repository.AdRepository
import javax.inject.Inject

class EditAdUseCase @Inject constructor(
    private val repository: AdRepository
) {

    suspend operator fun invoke(
        ad: Ad
    ) {
        repository.editAd(ad)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/AdUseCase/GetAdByIdUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.entity.Ad
import com.example.voborot.domain.repository.AdRepository
import javax.inject.Inject

class GetAdByIdUseCase @Inject constructor(
    private val repository: AdRepository
) {

    suspend operator fun invoke(
        adId: Int
    ): Ad {
        return repository.getAdById(adId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/AdUseCase/GetFavouriteAdsUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.entity.Ad
import com.example.voborot.domain.repository.AdRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouriteAdsUseCase @Inject constructor(
    private val repository: AdRepository
) {

    operator fun invoke(
        userId: Int
    ): Flow<List<Ad>> {
        return repository.getFavouriteAds(userId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/AdUseCase/GetFilteredAdsUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.entity.Ad
import com.example.voborot.domain.repository.AdRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFilteredAdsUseCase @Inject constructor(
    private val repository: AdRepository
) {

    operator fun invoke(
        query: String?,
        categoryId: Int?,
        minPrice: Int?,
        maxPrice: Int?
    ): Flow<List<Ad>> {
        return repository.getFilteredAds(
            query,
            categoryId,
            minPrice,
            maxPrice
        )
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/AdUseCase/GetLessorAdsUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.entity.Ad
import com.example.voborot.domain.repository.AdRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLessorAdsUseCase @Inject constructor(
    private val repository: AdRepository
) {

    operator fun invoke(
        lessorId: Int
    ): Flow<List<Ad>> {
        return repository.getLessorAds(lessorId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/AdUseCase/ToggleFavoriteUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.AdUseCase

import com.example.voborot.domain.repository.AdRepository
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val repository: AdRepository
) {

    suspend operator fun invoke(
        userId: Int,
        adId: Int
    ) {
        repository.toggleFavorite(userId, adId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/BookingUseCase/BookingConfirmationUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.BookingUseCase

import com.example.voborot.domain.repository.BookingRepository
import javax.inject.Inject

class BookingConfirmationUseCase @Inject constructor(
    private val repository: BookingRepository
) {

    suspend operator fun invoke(
        bookingId: Int
    ) {
        repository.bookingConfirmation(bookingId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/BookingUseCase/CancelBookingUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.BookingUseCase

import com.example.voborot.domain.repository.BookingRepository
import javax.inject.Inject

class CancelBookingUseCase @Inject constructor(
    private val repository: BookingRepository
) {

    suspend operator fun invoke(
        bookingId: Int
    ) {
        repository.cancelBooking(bookingId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/BookingUseCase/CreateBookingUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.BookingUseCase

import com.example.voborot.domain.repository.BookingRepository
import javax.inject.Inject

class CreateBookingUseCase @Inject constructor(
    private val repository: BookingRepository
) {

    suspend operator fun invoke(
        adId: Int,
        renterId: Int,
        startDate: Long,
        endDate: Long,
        count: Int
    ) {
        repository.createBooking(
            adId,
            renterId,
            startDate,
            endDate,
            count
        )
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/BookingUseCase/DeleteBookingUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.BookingUseCase

import com.example.voborot.domain.repository.BookingRepository
import javax.inject.Inject

class DeleteBookingUseCase @Inject constructor(
    private val repository: BookingRepository
) {

    suspend operator fun invoke(
        bookingId: Int
    ) {
        repository.deleteBooking(bookingId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/BookingUseCase/EarlyTerminationBookingUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.BookingUseCase

import com.example.voborot.domain.repository.BookingRepository
import javax.inject.Inject

class EarlyTerminationBookingUseCase @Inject constructor(
    private val repository: BookingRepository
) {

    suspend operator fun invoke(
        bookingId: Int
    ) {
        repository.earlyTerminationBooking(bookingId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/BookingUseCase/GetBookingByIdUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.BookingUseCase

import com.example.voborot.domain.entity.Booking
import com.example.voborot.domain.repository.BookingRepository
import javax.inject.Inject

class GetBookingByIdUseCase @Inject constructor(
    private val repository: BookingRepository
) {

    suspend operator fun invoke(
        bookingId: Int
    ): Booking {
        return repository.getBookingById(bookingId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/BookingUseCase/GetUserBookingsUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.BookingUseCase

import com.example.voborot.domain.entity.Booking
import com.example.voborot.domain.repository.BookingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserBookingsUseCase @Inject constructor(
    private val repository: BookingRepository
) {

    operator fun invoke(
        userId: Int
    ): Flow<List<Booking>> {
        return repository.getUserBookings(userId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/CategoryUseCase/GetAllCategoriesUseCase.kt`

````kotlin
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
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/FeedbackUseCase/CreateFeedbackUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.FeedbackUseCase

import com.example.voborot.domain.repository.FeedbackRepository
import javax.inject.Inject

class CreateFeedbackUseCase @Inject constructor(
    private val repository: FeedbackRepository
) {

    suspend operator fun invoke(
        bookingId: Int,
        mark: Int,
        text: String?
    ) {
        repository.createFeedback(bookingId, mark, text)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/FeedbackUseCase/DeleteFeedbackUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.FeedbackUseCase

import com.example.voborot.domain.repository.FeedbackRepository
import javax.inject.Inject

class DeleteFeedbackUseCase @Inject constructor(
    private val repository: FeedbackRepository
) {

    suspend operator fun invoke(
        bookingId: Int
    ) {
        repository.deleteFeedback(bookingId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/FeedbackUseCase/EditFeedbackUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.FeedbackUseCase

import com.example.voborot.domain.entity.Feedback
import com.example.voborot.domain.repository.FeedbackRepository
import javax.inject.Inject

class EditFeedbackUseCase @Inject constructor(
    private val repository: FeedbackRepository
) {

    suspend operator fun invoke(
        feedback: Feedback
    ) {
        repository.editFeedback(feedback)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/FeedbackUseCase/GetAllFeedbacksUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.FeedbackUseCase

import com.example.voborot.domain.entity.Feedback
import com.example.voborot.domain.repository.FeedbackRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFeedbacksUseCase @Inject constructor(
    private val repository: FeedbackRepository
) {

    operator fun invoke(
        adId: Int
    ): Flow<List<Feedback>> {
        return repository.getAllFeedbacks(adId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/UserUseCase/CreateUserUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.UserUseCase

import com.example.voborot.domain.repository.UserRepository
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        firstName: String,
        middleName: String?,
        lastName: String,
        userImage: String?,
        email: String,
        password: String
    ) {
        repository.createUser(
            firstName,
            middleName,
            lastName,
            userImage,
            email,
            password
        )
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/UserUseCase/DeleteUserUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.UserUseCase

import com.example.voborot.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        userId: Int
    ) {
        repository.deleteUser(userId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/UserUseCase/EditUserUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.UserUseCase

import com.example.voborot.domain.entity.User
import com.example.voborot.domain.repository.UserRepository
import javax.inject.Inject

class EditUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        user: User
    ) {
        repository.editUser(user)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/UserUseCase/GetCurrentUserUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.UserUseCase

import com.example.voborot.domain.entity.User
import com.example.voborot.domain.repository.UserRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
    ): User? {
        return repository.getCurrentUser()
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/UserUseCase/GetUserUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.UserUseCase

import com.example.voborot.domain.entity.User
import com.example.voborot.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        userId: Int
    ): User {
        return repository.getUser(userId)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/domain/usecase/UserUseCase/SignInUseCase.kt`

````kotlin
package com.example.voborot.domain.usecase.UserUseCase

import com.example.voborot.domain.entity.User
import com.example.voborot.domain.repository.UserRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        email: String,
        password: String
    ): User {
        return repository.signIn(email, password)
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/presentation/MainActivity.kt`

````kotlin
package com.example.voborot.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.voborot.presentation.ui.theme.VoborotTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VoborotTheme {

            }
        }
    }
}
````

---

### File: `app/src/main/java/com/example/voborot/presentation/ui/theme/Color.kt`

````kotlin
package com.example.voborot.presentation.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
````

---

### File: `app/src/main/java/com/example/voborot/presentation/ui/theme/Theme.kt`

````kotlin
package com.example.voborot.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun VoborotTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
````

---

### File: `app/src/main/java/com/example/voborot/presentation/ui/theme/Type.kt`

````kotlin
package com.example.voborot.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
````

---

### File: `app/src/main/res/values/colors.xml`

````xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="purple_200">#FFBB86FC</color>
    <color name="purple_500">#FF6200EE</color>
    <color name="purple_700">#FF3700B3</color>
    <color name="teal_200">#FF03DAC5</color>
    <color name="teal_700">#FF018786</color>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
</resources>
````

---

### File: `app/src/main/res/values/strings.xml`

````xml
<resources>
    <string name="app_name">Voborot</string>
</resources>
````

---

### File: `app/src/main/res/values/themes.xml`

````xml
<?xml version="1.0" encoding="utf-8"?>
<resources>

    <style name="Theme.Voborot" parent="android:Theme.Material.Light.NoActionBar" />
</resources>
````

---

### File: `app/src/main/res/xml/backup_rules.xml`

````xml
<?xml version="1.0" encoding="utf-8"?><!--
   Sample backup rules file; uncomment and customize as necessary.
   See https://developer.android.com/guide/topics/data/autobackup
   for details.
   Note: This file is ignored for devices older than API 31
   See https://developer.android.com/about/versions/12/backup-restore
-->
<full-backup-content>
    <!--
   <include domain="sharedpref" path="."/>
   <exclude domain="sharedpref" path="device.xml"/>
-->
</full-backup-content>
````

---

### File: `app/src/main/res/xml/data_extraction_rules.xml`

````xml
<?xml version="1.0" encoding="utf-8"?><!--
   Sample data extraction rules file; uncomment and customize as necessary.
   See https://developer.android.com/about/versions/12/backup-restore#xml-changes
   for details.
-->
<data-extraction-rules>
    <cloud-backup>
        <!-- TODO: Use <include> and <exclude> to control what is backed up.
        <include .../>
        <exclude .../>
        -->
    </cloud-backup>
    <!--
    <device-transfer>
        <include .../>
        <exclude .../>
    </device-transfer>
    -->
</data-extraction-rules>
````

---

### File: `app/src/test/java/com/example/voborot/ExampleUnitTest.kt`

````kotlin
package com.example.voborot

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
````

---

### File: `gradle/gradle-daemon-jvm.properties`

````properties
#This file is generated by updateDaemonJvm
toolchainUrl.FREE_BSD.AARCH64=https\://api.foojay.io/disco/v3.0/ids/cf726b4a1c84b50457225f9bba6d7650/redirect
toolchainUrl.FREE_BSD.X86_64=https\://api.foojay.io/disco/v3.0/ids/fa1e318c287360478e3c83a9a3ef1007/redirect
toolchainUrl.LINUX.AARCH64=https\://api.foojay.io/disco/v3.0/ids/cf726b4a1c84b50457225f9bba6d7650/redirect
toolchainUrl.LINUX.X86_64=https\://api.foojay.io/disco/v3.0/ids/fa1e318c287360478e3c83a9a3ef1007/redirect
toolchainUrl.MAC_OS.AARCH64=https\://api.foojay.io/disco/v3.0/ids/c2dd35c9d0aaf0ba6ad0791320f99dfc/redirect
toolchainUrl.MAC_OS.X86_64=https\://api.foojay.io/disco/v3.0/ids/e5810bd7fd1f8a586644409d395a7e55/redirect
toolchainUrl.UNIX.AARCH64=https\://api.foojay.io/disco/v3.0/ids/cf726b4a1c84b50457225f9bba6d7650/redirect
toolchainUrl.UNIX.X86_64=https\://api.foojay.io/disco/v3.0/ids/fa1e318c287360478e3c83a9a3ef1007/redirect
toolchainUrl.WINDOWS.AARCH64=https\://api.foojay.io/disco/v3.0/ids/7b3c4877c0749019e6805bb61e421497/redirect
toolchainUrl.WINDOWS.X86_64=https\://api.foojay.io/disco/v3.0/ids/d76df094a9cbbabd3b08251f9e61444a/redirect
toolchainVersion=25
````

---

### File: `gradle/libs.versions.toml`

````toml
[versions]
agp = "9.4.1"
coilNetworkOkhttp = "3.6.3"
coreKtx = "1.19.1"
hiltAndroidVersion = "2.60.1"
hiltNavigationCompose = "1.4.0"
junit = "4.13.2"
junitVersion = "1.3.0"
espressoCore = "3.7.0"
kotlinxSerializationJson = "1.12.0"
lifecycleRuntimeKtx = "2.11.0"
activityCompose = "1.13.0"
kotlin = "2.4.21"
composeBom = "2026.09.00"
navigationCompose = "2.10.2"
ksp = "2.3.6"
roomCompiler = "2.8.5"

[libraries]
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
androidx-hilt-navigation-compose = { module = "androidx.hilt:hilt-navigation-compose", version.ref = "hiltNavigationCompose" }
androidx-navigation-compose = { module = "androidx.navigation:navigation-compose", version.ref = "navigationCompose" }
androidx-room-compiler = { module = "androidx.room:room-compiler", version.ref = "roomCompiler" }
androidx-room-ktx = { module = "androidx.room:room-ktx", version.ref = "roomCompiler" }
androidx-room-runtime = { module = "androidx.room:room-runtime", version.ref = "roomCompiler" }
coil-compose = { module = "io.coil-kt.coil3:coil-compose", version.ref = "coilNetworkOkhttp" }
coil-network-okhttp = { module = "io.coil-kt.coil3:coil-network-okhttp", version.ref = "coilNetworkOkhttp" }
hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hiltAndroidVersion" }
hilt-android-compiler = { module = "com.google.dagger:hilt-android-compiler", version.ref = "hiltAndroidVersion" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-activity-compose = { group = "androidx.activity", name = "activity-compose", version.ref = "activityCompose" }
androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
androidx-compose-ui = { group = "androidx.compose.ui", name = "ui" }
androidx-compose-ui-graphics = { group = "androidx.compose.ui", name = "ui-graphics" }
androidx-compose-ui-tooling = { group = "androidx.compose.ui", name = "ui-tooling" }
androidx-compose-ui-tooling-preview = { group = "androidx.compose.ui", name = "ui-tooling-preview" }
androidx-compose-ui-test-manifest = { group = "androidx.compose.ui", name = "ui-test-manifest" }
androidx-compose-ui-test-junit4 = { group = "androidx.compose.ui", name = "ui-test-junit4" }
androidx-compose-material3 = { group = "androidx.compose.material3", name = "material3" }
kotlinx-serialization-json = { module = "org.jetbrains.kotlinx:kotlinx-serialization-json", version.ref = "kotlinxSerializationJson" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
kotlin-compose = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
hilt-android = { id = "com.google.dagger.hilt.android", version.ref = "hiltAndroidVersion" }
ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
kotlin-serialization = { id = "org.jetbrains.kotlin.plugin.serialization", version.ref = "kotlin" }
````

---

### File: `gradle/wrapper/gradle-wrapper.properties`

````properties
#Tue Oct 20 14:05:31 GMT+07:00 2026
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionSha256Sum=bbaeb2fef8710818cf0e261201dab964c572f92b942812df0c3620d62a529a01
distributionUrl=https\://services.gradle.org/distributions/gradle-9.6.0-bin.zip
networkTimeout=10000
validateDistributionUrl=true
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
````

---

