package com.example.pizzarestaurant.domain.usecase

import com.example.pizzarestaurant.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserUseCase {
    fun getUser() :Flow<User?>
    fun setUser(user:User)
}