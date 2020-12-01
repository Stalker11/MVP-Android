package com.example.mvplearn

import com.example.mvplearn.contract.Contract
import com.example.mvplearn.models.User
import com.example.mvplearn.presenter.FirstViewPresenter
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

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
        mockView?.let { presenter?.attachView(it) }
     //   then(mockView).should()?.saveSuccess()
        presenter?.save(User("w","w"))
        verify(mockView)?.saveSuccess()
    }

    @After
    fun detachPresenter(){
        presenter?.detachView()
        presenter?.unsubscribe()
        presenter = null
    }
}