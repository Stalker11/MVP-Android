package com.example.mvplearn.presenter

import com.example.mvplearn.contract.Contract
import com.example.mvplearn.models.User

class FirstViewPresenter: BasePresenter<Contract.FirstView>(), Contract.Presenter {
    override fun save(user: User) {
        if(user.firstName.isNotBlank() && user.secondName.isNotBlank()){
            mView?.saveSuccess()
        }
        else{
            mView?.error("Names cannot be empty")
        }

    }

    override fun isReady() {
        TODO("Not yet implemented")
    }

}