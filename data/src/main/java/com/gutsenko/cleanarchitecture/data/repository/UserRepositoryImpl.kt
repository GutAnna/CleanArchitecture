package com.gutsenko.cleanarchitecture.data.repository

import com.gutsenko.cleanarchitecture.data.storage.models.User
import com.gutsenko.cleanarchitecture.data.storage.UserStorage
import com.gutsenko.cleanarchitecture.domain.models.SaveUserNameParam
import com.gutsenko.cleanarchitecture.domain.models.UserName
import com.gutsenko.cleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        return userStorage.save(User(saveParam.name, " "))
    }

    override fun getName(): UserName {
        return mapToDomain(userStorage.get())
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(user.firstName, user.lastName)
    }

}