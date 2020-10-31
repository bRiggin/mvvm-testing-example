package com.briggin.mvvmtest

import androidx.annotation.StringRes

class MainPresenter {

    private var view: View? = null

    fun bind(view: View) {
        this.view = view
    }

    fun unbind() {
        this.view = null
    }

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
        view?.apply {
            setTitle(state.title)
            setSubTitle(state.subTitle)
            setDescription(state.description)
            setProgress(state.progressBar)
            setSwitch(state.switch)
            setCheckBox(state.checkBox)
            displayLoader(state.showProgress)
        }
    }

    interface View {
        fun setTitle(@StringRes titleResId: Int)
        fun setSubTitle(@StringRes subTitleResId: Int)
        fun setDescription(@StringRes descriptionResId: Int)
        fun setProgress(progress: Int)
        fun setSwitch(isSwitched: Boolean)
        fun setCheckBox(isChecked: Boolean)
        fun displayLoader(visibility: Int)
    }
}
