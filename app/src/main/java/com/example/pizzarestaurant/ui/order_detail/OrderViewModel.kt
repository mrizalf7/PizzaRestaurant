package com.example.pizzarestaurant.ui.order_detail

import androidx.lifecycle.ViewModel
import com.example.pizzarestaurant.domain.model.User
import com.example.pizzarestaurant.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(useCase : UserUseCase) : ViewModel() {

    val getUser=useCase.getUser()

}