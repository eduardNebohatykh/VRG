package com.example.vrgtask.screens.main.api

import com.example.vrgtask.app.model.MostPopularResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MainApi {

    @GET("emailed/{period}.json")
    fun getMostEmailedArticles(@Path("period") period: Int,
                               @Query("api-key") apiKey: String): Single<MostPopularResponse>

    @GET("shared/{period}.json")
    fun getMostSharedArticles(@Path("period") period: Int,
                              @Query("api-key") apiKey: String): Single<MostPopularResponse>

    @GET("viewed/{period}.json")
    fun getMostViewedArticles(@Path("period") period: Int,
                              @Query("api-key") apiKey: String): Single<MostPopularResponse>
}