package com.gutsenko.cleanarchitecture.domain.repository

import com.gutsenko.cleanarchitecture.domain.models.SaveUserNameParam
import com.gutsenko.cleanarchitecture.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}