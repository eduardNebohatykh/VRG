package com.example.vrgtask.app

import android.app.Application
import com.example.vrgtask.app.di.AppComponent
import com.example.vrgtask.app.di.AppModule
import com.example.vrgtask.app.di.DaggerAppComponent

class App: Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .plus(AppModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}