package com.gutsenko.cleanarchitecture.di

import android.content.Context
import com.gutsenko.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.gutsenko.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import com.gutsenko.cleanarchitecture.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }
    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ) : MainViewModelFactory {
        return MainViewModelFactory(getUserNameUseCase,saveUserNameUseCase)
    }
}