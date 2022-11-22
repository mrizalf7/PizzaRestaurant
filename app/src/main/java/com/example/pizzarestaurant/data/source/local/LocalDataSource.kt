package com.example.pizzarestaurant.data.source.local

import com.example.pizzarestaurant.data.source.local.entity.UserEntity
import com.example.pizzarestaurant.data.source.local.room.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val userDae: UserDao): UserDao {

    override fun getUser(): Flow<UserEntity?> {
       return userDae.getUser()
    }
     override fun setUser(user:UserEntity) = userDae.setUser(user)

}