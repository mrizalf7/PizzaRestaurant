package com.example.pizzarestaurant.di

import android.content.Context
import androidx.room.Room
import com.example.pizzarestaurant.data.source.local.room.UserDao
import com.example.pizzarestaurant.data.source.local.room.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase = Room.databaseBuilder(
        context,
        UserDatabase::class.java, "User.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideDao(database: UserDatabase): UserDao = database.guestUserDao()
}