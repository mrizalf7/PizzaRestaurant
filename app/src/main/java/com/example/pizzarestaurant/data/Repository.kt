package com.example.pizzarestaurant.data

import com.example.pizzarestaurant.data.source.local.LocalDataSource
import com.example.pizzarestaurant.domain.model.User
import com.example.pizzarestaurant.utils.AppExecutors
import com.example.pizzarestaurant.utils.UserDataMapper
import com.example.pizzarestaurant.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Repository @Inject constructor
    (private val localDataSource: LocalDataSource,
     private val appExecutors: AppExecutors
)
    : IRepository {

    override fun getUser(): Flow<User> {
        return localDataSource.getUser().map {
            UserDataMapper.mapEntityToDomain(it)
        }
    }

    override fun setUser(user: User) {
        val userEntity = UserDataMapper.mapDomainToEntity(user)
        appExecutors.diskIO().execute { localDataSource.setUser(userEntity) }
    }

}