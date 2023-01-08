package com.gutsenko.cleanarchitecture.domain.usecase

import com.gutsenko.cleanarchitecture.domain.models.SaveUserNameParam
import com.gutsenko.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam) : Boolean {
        return userRepository.saveName(param)
    }
}