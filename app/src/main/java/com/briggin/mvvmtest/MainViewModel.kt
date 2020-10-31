package com.briggin.mvvmtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _state: MutableLiveData<State> = MutableLiveData()
    val title: LiveData<Int> = Transformations.distinctUntilChanged(Transformations.map(_state) { it.title })
    val subTitle: LiveData<Int> = Transformations.distinctUntilChanged(Transformations.map(_state) { it.subTitle })
    val description: LiveData<Int> = Transformations.distinctUntilChanged(Transformations.map(_state) { it.description })
    val progressBar: LiveData<Int> = Transformations.distinctUntilChanged(Transformations.map(_state) { it.progressBar })
    val checkbox: LiveData<Boolean> = Transformations.distinctUntilChanged(Transformations.map(_state) { it.checkBox })
    val switch: LiveData<Boolean> = Transformations.distinctUntilChanged(Transformations.map(_state) { it.switch })
    val showProgressBar: LiveData<Int> = Transformations.distinctUntilChanged(Transformations.map(_state) { it.showProgress })

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
