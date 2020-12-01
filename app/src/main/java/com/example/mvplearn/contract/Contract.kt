package com.example.mvplearn.contract

import com.example.mvplearn.models.User

interface Contract {
    interface FirstView:BaseView{
      fun saveSuccess()
      fun error()
      fun error(message:String)
    }
    interface Presenter:BasePresenter<FirstView>{
      fun save(user: User)
    }
}


