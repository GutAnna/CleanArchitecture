package com.gutsenko.cleanarchitecture.di

import com.gutsenko.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.gutsenko.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }
    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}