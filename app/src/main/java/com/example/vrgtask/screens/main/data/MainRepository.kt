package com.example.vrgtask.screens.main.data

import com.example.vrgtask.app.model.MostPopularResponse
import com.example.vrgtask.screens.main.ArticlesTypeEnum
import com.example.vrgtask.screens.main.MainContract
import com.example.vrgtask.screens.main.api.MainApi
import io.reactivex.Single

class MainRepository(private val api: MainApi) : MainContract.Repo {

    override fun getMostPopularArticles(period: Int, apiKey: String, type: ArticlesTypeEnum): Single<MostPopularResponse> {
        return when(type) {
            ArticlesTypeEnum.EMAILED -> api.getMostEmailedArticles(period, apiKey)
            ArticlesTypeEnum.SHARED -> api.getMostSharedArticles(period, apiKey)
            ArticlesTypeEnum.VIEWED -> api.getMostViewedArticles(period, apiKey)
        }
    }
}