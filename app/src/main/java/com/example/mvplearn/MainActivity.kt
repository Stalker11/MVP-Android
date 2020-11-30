package com.example.mvplearn

import android.os.Bundle
import com.example.mvplearn.contract.Contract
import com.example.mvplearn.databinding.ActivityMainBinding
import com.example.mvplearn.models.User
import com.example.mvplearn.presenter.FirstViewPresenter
import com.example.mvplearn.ui.BaseActivity

class MainActivity : BaseActivity(), Contract.FirstView {
    lateinit var firstPresenter: FirstViewPresenter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firstPresenter = FirstViewPresenter()
        firstPresenter.attachView(this) // BE CAREFUL. Can reproduce crash in future.
        // Programmer must control lifecycle
        binding.mainActivitySaveBtn.setOnClickListener {
            val user = User(
                binding.mainActivityFirstName.text.toString(),
                binding.mainActivityLastName.text.toString()
            )
            firstPresenter.save(user)
        }
    }

    override fun saveSuccess() {
        showToast("${this.firstPresenter.javaClass.simpleName} saved data success")
    }

    override fun error() {

    }

    override fun error(message: String) {
        showToast("${this.firstPresenter.javaClass.simpleName} $message")
    }

    override fun onDestroy() {
        super.onDestroy()
        firstPresenter.unsubscribe()
        firstPresenter.detachView() //Can reproduce null pointer exception
    }
}