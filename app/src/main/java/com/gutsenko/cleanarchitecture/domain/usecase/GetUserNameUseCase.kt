package com.gutsenko.cleanarchitecture.domain.usecase

import com.gutsenko.cleanarchitecture.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Kiparo", lastName = "Hello")
    }
}