package com.example.mvplearn.presenter

import com.example.mvplearn.contract.BasePresenter
import com.example.mvplearn.contract.BaseView

abstract class BasePresenter<T : BaseView> : BasePresenter<T> {
    var mView: T? = null
    override fun attachView(view: T) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }

    fun isAttached() = { mView != null }

    fun getView() = { mView }

    override fun destroyView() {
        //Here can be cancelled working Rx or coroutine thread
    }
}

