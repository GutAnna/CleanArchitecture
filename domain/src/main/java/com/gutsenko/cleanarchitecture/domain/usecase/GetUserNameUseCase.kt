package com.gutsenko.cleanarchitecture.domain.usecase

import com.gutsenko.cleanarchitecture.domain.models.UserName
import com.gutsenko.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}