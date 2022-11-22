package com.example.pizzarestaurant.ui.home_screen

import androidx.lifecycle.ViewModel
import com.example.pizzarestaurant.domain.model.User
import com.example.pizzarestaurant.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase : UserUseCase) : ViewModel() {

    fun setUser(user:User) {
        return useCase.setUser(user)
    }

}