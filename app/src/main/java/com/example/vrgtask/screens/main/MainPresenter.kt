package com.example.vrgtask.screens.main

import com.example.vrgtask.app.model.MostPopularResponse

class MainPresenter(private val router: MainContract.Router, private val interactor: MainInteractor) :
        MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun bindView(view: MainContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
        interactor.dispose()
    }

    override fun onViewCreated(articlesTypeEnum: ArticlesTypeEnum) {
        view?.showLoading()
        interactor.getArticles(articlesTypeEnum, this::onSuccess, this::onError)
    }

    private fun onSuccess(response: MostPopularResponse) {
        view?.hideLoading()
        response.results?.let { view?.publishData(it) }
    }

    private fun onError(error: Throwable) {
        view?.hideLoading()
        error.message?.let { view?.showMessage(it) }
    }
}