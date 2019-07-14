package com.example.vrgtask.screens.main

class MainRouter(private val activity: MainActivity) : MainContract.Router {

    override fun finish() = activity.finish()
}