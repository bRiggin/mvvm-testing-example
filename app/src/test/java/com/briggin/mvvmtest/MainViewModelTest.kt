package com.briggin.mvvmtest

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
            state.observeForever {}
        }
    }

    @Test
    fun `WHEN state one triggered THEN expect state one UI displayed`() {
        viewModel.setStateOne()
        assertEquals(StateOne, viewModel.state.value)
    }

    @Test
    fun `WHEN state two triggered THEN expect state two UI displayed`() {
        viewModel.setStateTwo()
        assertEquals(StateTwo, viewModel.state.value)
    }

    @Test
    fun `WHEN state three triggered THEN expect state three UI displayed`() {
        viewModel.setStateThree()
        assertEquals(StateThree, viewModel.state.value)
    }

    @Test
    fun `WHEN state four triggered THEN expect state four UI displayed`() {
        viewModel.setStateFour()
        assertEquals(StateFour, viewModel.state.value)
    }
}
