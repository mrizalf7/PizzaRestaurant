package com.example.pizzarestaurant.utils

import com.example.pizzarestaurant.data.source.local.entity.UserEntity
import com.example.pizzarestaurant.domain.model.User

object UserDataMapper {


    fun mapEntityToDomain(input: UserEntity?): User {
        return if (input != null) {
            User(
                username = input.username,
                location = input.location,
            )
        }
        else {
            User(
                username = input?.username,
                location = input?.location,
            )
        }
    }

    fun mapDomainToEntity(input: User): UserEntity {
        return UserEntity(
            username = input.username,
            location = input.location,
        )
    }
}

