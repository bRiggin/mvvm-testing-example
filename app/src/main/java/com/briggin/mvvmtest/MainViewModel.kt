package com.briggin.mvvmtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _state: MutableLiveData<State> = MutableLiveData()
    val state: LiveData<State> = _state

    fun setStateOne() {
        _state.postValue(StateOne)
    }

    fun setStateTwo() {
        _state.postValue(StateTwo)
    }

    fun setStateThree() {
        _state.postValue(StateThree)
    }

    fun setStateFour() {
        _state.postValue(StateFour)
    }
}
