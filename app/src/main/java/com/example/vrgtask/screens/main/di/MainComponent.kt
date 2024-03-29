package com.example.vrgtask.screens.main.di

import com.example.vrgtask.app.di.ActivityScope
import com.example.vrgtask.app.di.AppComponent
import com.example.vrgtask.screens.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [MainModule::class], dependencies = [AppComponent::class])
interface MainComponent {

    fun inject(target: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: MainActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: MainModule): Builder

        fun build(): MainComponent
    }
}