package com.example.mvplearn.contract

interface BasePresenter<V : BaseView> {
    fun attachView(view:V)
    fun isReady()
    fun detachView()
    fun unsubscribe()
}



