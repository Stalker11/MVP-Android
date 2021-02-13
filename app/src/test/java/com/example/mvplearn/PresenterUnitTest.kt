package com.example.mvplearn

import com.example.mvplearn.contract.Contract
import com.example.mvplearn.models.User
import com.example.mvplearn.presenter.FirstViewPresenter
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito.mock

class PresenterUnitTest {
    private var presenter: FirstViewPresenter? = null
    private lateinit var mockView: Contract.FirstView

    @Before
    fun initPresenter() {
        presenter = FirstViewPresenter()
        mockView = mock(Contract.FirstView::class.java)
    }

    @Test
    fun testPresenter() {
        mockView.let { presenter?.attachView(it) }
        presenter?.save(User("","w"))
        then(mockView).should()?.error("Names cannot be empty")
        //verify(mockView)?.saveSuccess()
    }

    @After
    fun detachPresenter(){
        presenter?.detachView()
        presenter?.unsubscribe()
        presenter = null
    }
}