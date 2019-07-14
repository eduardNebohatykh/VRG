package com.example.vrgtask.screens.main.di

import com.example.vrgtask.app.di.ActivityScope
import com.example.vrgtask.screens.main.*
import com.example.vrgtask.screens.main.api.MainApi
import com.example.vrgtask.screens.main.data.MainRepository
import com.example.vrgtask.screens.main.MainInteractor
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {

    @Provides
    @ActivityScope
    fun api(retrofit: Retrofit) = retrofit.create(MainApi::class.java)

    @Provides
    @ActivityScope
    fun repository(api: MainApi) = MainRepository(api)


    @Provides
    @ActivityScope
    fun router(activity: MainActivity): MainContract.Router = MainRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: MainContract.Router, interactor: MainInteractor) = MainPresenter(router, interactor)

    @Provides
    @ActivityScope
    fun interactor(repository: MainRepository) = MainInteractor(repository)
}