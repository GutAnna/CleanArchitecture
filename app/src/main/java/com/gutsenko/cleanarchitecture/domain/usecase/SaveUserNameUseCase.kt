package com.gutsenko.cleanarchitecture.domain.usecase

import com.gutsenko.cleanarchitecture.domain.models.SaveUserNameParam

class SaveUserNameUseCase {
    fun execute(param: SaveUserNameParam) : Boolean {
        return (param.name.isNotEmpty())
    }
}