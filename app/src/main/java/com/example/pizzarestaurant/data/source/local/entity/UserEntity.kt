package com.example.pizzarestaurant.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_DB")
data class UserEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int?=0,

    @ColumnInfo(name = "username")
    val username: String?,

    @ColumnInfo(name = "location")
    val location: String?,
)