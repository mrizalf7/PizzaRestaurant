package com.example.pizzarestaurant.domain.repository

import com.example.pizzarestaurant.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IRepository {


    fun getUser(): Flow<User>
    fun setUser(user: User)

}