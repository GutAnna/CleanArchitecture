package com.gutsenko.cleanarchitecture.di

import com.gutsenko.cleanarchitecture.data.repository.UserRepositoryImpl
import com.gutsenko.cleanarchitecture.data.storage.UserStorage
import com.gutsenko.cleanarchitecture.data.storage.sharedPrefs.SharedPrefsUserStorage
import com.gutsenko.cleanarchitecture.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {
    single<UserStorage> {
        SharedPrefsUserStorage(context = get())
    }


    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}


