package com.example.vrgtask.screens.main

import com.example.vrgtask.app.model.ArticleInfo
import com.example.vrgtask.app.model.MostPopularResponse
import io.reactivex.Single

interface MainContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun publishData(data: List<ArticleInfo>)
        fun showMessage(msg: String)
    }

    interface Presenter {
        fun bindView(view: MainContract.View)
        fun unbindView()
        fun onViewCreated(articlesTypeEnum: ArticlesTypeEnum)
    }

    interface Interactor {
        fun getArticles(type: ArticlesTypeEnum, onSuccess: (MostPopularResponse) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun finish()
    }

    interface Repo {
        fun getMostPopularArticles(period: Int, apiKey: String, type: ArticlesTypeEnum): Single<MostPopularResponse>
    }
}