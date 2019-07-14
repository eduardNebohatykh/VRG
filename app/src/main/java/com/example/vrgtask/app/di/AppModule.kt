package com.example.vrgtask.app.di

import com.example.vrgtask.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun retrofit() = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.SERVER_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor())
                .build()
        )
        .build()

    private fun loggingInterceptor() = HttpLoggingInterceptor().setLevel(BODY)
}