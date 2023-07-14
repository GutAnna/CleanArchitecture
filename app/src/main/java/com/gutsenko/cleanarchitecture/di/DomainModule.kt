package com.gutsenko.cleanarchitecture.di

import com.gutsenko.cleanarchitecture.domain.repository.UserRepository
import com.gutsenko.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.gutsenko.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository)
    }
    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository)
    }
}