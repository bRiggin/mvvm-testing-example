package com.briggin.mvvmtest

import android.view.View
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before

import org.junit.Test

class MainPresenterTest {

    private val view: MainPresenter.View = mockk(relaxed = true)

    private lateinit var presenter: MainPresenter

    @Before
    fun `configure test`() {
        presenter = MainPresenter().apply {
            bind(view)
        }
    }

    @Test
    fun `WHEN state one triggered THEN expect state one UI displayed`() {
        presenter.setStateOne()

        verify { view.setTitle(R.string.state_one_title) }
        verify { view.setSubTitle(R.string.sub_title_one) }
        verify { view.setDescription(R.string.description) }
        verify { view.setProgress(50) }
        verify { view.setSwitch(true) }
        verify { view.setCheckBox(true) }
        verify { view.displayLoader(View.VISIBLE) }
    }

    @Test
    fun `WHEN state two triggered THEN expect state two UI displayed`() {
        presenter.setStateTwo()

        verify { view.setTitle(R.string.state_two_title) }
        verify { view.setSubTitle(R.string.sub_title_two) }
        verify { view.setDescription(R.string.description) }
        verify { view.setProgress(0) }
        verify { view.setSwitch(false) }
        verify { view.setCheckBox(true) }
        verify { view.displayLoader(View.INVISIBLE) }
    }

    @Test
    fun `WHEN state three triggered THEN expect state three UI displayed`() {
        presenter.setStateThree()

        verify { view.setTitle(R.string.state_three_title) }
        verify { view.setSubTitle(R.string.sub_title_one) }
        verify { view.setDescription(R.string.description) }
        verify { view.setProgress(100) }
        verify { view.setSwitch(true) }
        verify { view.setCheckBox(false) }
        verify { view.displayLoader(View.VISIBLE) }
    }

    @Test
    fun `WHEN state four triggered THEN expect state four UI displayed`() {
        presenter.setStateFour()

        verify { view.setTitle(R.string.state_four_title) }
        verify { view.setSubTitle(R.string.sub_title_two) }
        verify { view.setDescription(R.string.description) }
        verify { view.setProgress(75) }
        verify { view.setSwitch(false) }
        verify { view.setCheckBox(false) }
        verify { view.displayLoader(View.INVISIBLE) }
    }
}
