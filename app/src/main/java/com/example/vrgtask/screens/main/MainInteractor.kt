package com.example.vrgtask.screens.main

import com.example.vrgtask.BuildConfig
import com.example.vrgtask.app.model.MostPopularResponse
import com.example.vrgtask.screens.main.data.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainInteractor(private val repository: MainRepository) : MainContract.Interactor {

    companion object {
        const val PERIOD = 30
    }

    private val compositeDisposable = CompositeDisposable()

    override fun getArticles(type: ArticlesTypeEnum,
                             onSuccess: (MostPopularResponse) -> Unit, onError: (Throwable) -> Unit) {

        val disposable = repository.getMostPopularArticles(PERIOD, BuildConfig.API_KEY, type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(onError)
                .doOnSuccess(onSuccess)
                .subscribe()

        compositeDisposable.add(disposable)
    }

    fun dispose() = compositeDisposable.dispose()
}