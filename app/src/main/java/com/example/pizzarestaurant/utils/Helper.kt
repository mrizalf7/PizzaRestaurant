package com.example.pizzarestaurant.utils

object Helper {

    fun String.capitalizeFirstLetter() = this[0].uppercaseChar().plus(this.substring(1))

}