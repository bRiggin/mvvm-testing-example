package com.briggin.mvvmtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _title: MutableLiveData<Int> = MutableLiveData()
    val title: LiveData<Int> = _title
    private val _subTitle: MutableLiveData<Int> = MutableLiveData()
    val subTitle: LiveData<Int> = _subTitle
    private val _description: MutableLiveData<Int> = MutableLiveData()
    val description: LiveData<Int> = _description
    private val _progressBar: MutableLiveData<Int> = MutableLiveData()
    val progressBar: LiveData<Int> = _progressBar
    private val _checkbox: MutableLiveData<Boolean> = MutableLiveData()
    val checkbox: LiveData<Boolean> = _checkbox
    private val _switch: MutableLiveData<Boolean> = MutableLiveData()
    val switch: LiveData<Boolean> = _switch
    private val _showProgressBar: MutableLiveData<Int> = MutableLiveData()
    val showProgressBar: LiveData<Int> = _showProgressBar

    fun setStateOne() {
        updateView(StateOne)
    }

    fun setStateTwo() {
        updateView(StateTwo)
    }

    fun setStateThree() {
        updateView(StateThree)
    }

    fun setStateFour() {
        updateView(StateFour)
    }

    private fun updateView(state: State) {
        _title.postValue(state.title)
        _subTitle.postValue(state.subTitle)
        _description.postValue(state.description)
        _progressBar.postValue(state.progressBar)
        _checkbox.postValue(state.checkBox)
        _switch.postValue(state.switch)
        _showProgressBar.postValue(state.showProgress)
    }
}
