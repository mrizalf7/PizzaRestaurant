package com.example.pizzarestaurant.domain.usecase

import com.example.pizzarestaurant.domain.model.User
import com.example.pizzarestaurant.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserInteractor @Inject constructor (private val repository: IRepository) : UserUseCase {


    override fun getUser(): Flow<User?> {
        return repository.getUser()
    }

    override fun setUser(user: User) {
        return repository.setUser(user)
    }

}