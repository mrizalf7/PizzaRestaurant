package com.example.pizzarestaurant.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pizzarestaurant.data.source.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM User_DB")
    fun getUser() : Flow<UserEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setUser(user:UserEntity)

}