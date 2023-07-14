package com.gutsenko.cleanarchitecture.app

import android.app.Application
import com.gutsenko.cleanarchitecture.di.AppComponent
import com.gutsenko.cleanarchitecture.di.AppModule
import com.gutsenko.cleanarchitecture.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}