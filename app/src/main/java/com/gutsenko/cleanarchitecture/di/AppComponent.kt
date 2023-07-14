package com.gutsenko.cleanarchitecture.di

import com.gutsenko.cleanarchitecture.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class,DomainModule::class,DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}