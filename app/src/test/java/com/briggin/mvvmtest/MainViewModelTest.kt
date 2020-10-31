package com.briggin.mvvmtest

import android.view.View
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun `configure test`() {
        viewModel = MainViewModel().apply {
            title.observeForever {}
            subTitle.observeForever {}
            description.observeForever {}
            progressBar.observeForever {}
            switch.observeForever {}
            checkbox.observeForever {}
            showProgressBar.observeForever {}
        }
    }

    @Test
    fun `WHEN state one triggered THEN expect state one UI displayed`() {
        viewModel.setStateOne()

        assertEquals(R.string.state_one_title, viewModel.title.value)
        assertEquals(R.string.sub_title_one, viewModel.subTitle.value)
        assertEquals(R.string.description, viewModel.description.value)
        assertEquals(50, viewModel.progressBar.value)
        assertEquals(true, viewModel.switch.value)
        assertEquals(true, viewModel.checkbox.value)
        assertEquals(View.VISIBLE, viewModel.showProgressBar.value)
    }

    @Test
    fun `WHEN state two triggered THEN expect state two UI displayed`() {
        viewModel.setStateTwo()

        assertEquals(R.string.state_two_title, viewModel.title.value)
        assertEquals(R.string.sub_title_two, viewModel.subTitle.value)
        assertEquals(R.string.description, viewModel.description.value)
        assertEquals(0, viewModel.progressBar.value)
        assertEquals(false, viewModel.switch.value)
        assertEquals(true, viewModel.checkbox.value)
        assertEquals(View.INVISIBLE, viewModel.showProgressBar.value)
    }

    @Test
    fun `WHEN state three triggered THEN expect state three UI displayed`() {
        viewModel.setStateThree()

        assertEquals(R.string.state_three_title, viewModel.title.value)
        assertEquals(R.string.sub_title_one, viewModel.subTitle.value)
        assertEquals(R.string.description, viewModel.description.value)
        assertEquals(100, viewModel.progressBar.value)
        assertEquals(true, viewModel.switch.value)
        assertEquals(false, viewModel.checkbox.value)
        assertEquals(View.VISIBLE, viewModel.showProgressBar.value)
    }

    @Test
    fun `WHEN state four triggered THEN expect state four UI displayed`() {
        viewModel.setStateFour()

        assertEquals(R.string.state_four_title, viewModel.title.value)
        assertEquals(R.string.sub_title_two, viewModel.subTitle.value)
        assertEquals(R.string.description, viewModel.description.value)
        assertEquals(75, viewModel.progressBar.value)
        assertEquals(false, viewModel.switch.value)
        assertEquals(false, viewModel.checkbox.value)
        assertEquals(View.INVISIBLE, viewModel.showProgressBar.value)
    }
}
