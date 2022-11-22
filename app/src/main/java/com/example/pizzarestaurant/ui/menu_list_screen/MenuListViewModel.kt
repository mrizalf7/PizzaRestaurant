package com.example.pizzarestaurant.ui.menu_list_screen

import androidx.lifecycle.ViewModel
import com.example.pizzarestaurant.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuListViewModel @Inject constructor(useCase : UserUseCase) : ViewModel() {

    val getUser=useCase.getUser()

}