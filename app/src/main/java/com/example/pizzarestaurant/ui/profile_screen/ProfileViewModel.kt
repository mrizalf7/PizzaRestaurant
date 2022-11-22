package com.example.pizzarestaurant.ui.profile_screen

import androidx.lifecycle.ViewModel
import com.example.pizzarestaurant.domain.model.User
import com.example.pizzarestaurant.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(useCase : UserUseCase) : ViewModel() {

    val getUser=useCase.getUser()

    }
