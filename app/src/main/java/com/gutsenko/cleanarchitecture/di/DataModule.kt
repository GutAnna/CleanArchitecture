package com.gutsenko.cleanarchitecture.di

import android.content.Context
import com.gutsenko.cleanarchitecture.data.repository.UserRepositoryImpl
import com.gutsenko.cleanarchitecture.data.storage.UserStorage
import com.gutsenko.cleanarchitecture.data.storage.sharedPrefs.SharedPrefsUserStorage
import com.gutsenko.cleanarchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefsUserStorage(context)
    }
    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }
}
