package com.briggin.mvvmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.main_activity.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        presenter = MainPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.bind(this)

        button.setOnClickListener {
            presenter.setStateOne()
            Log.i(TAG, "State One being set")
        }
        button2.setOnClickListener {
            presenter.setStateTwo()
            Log.i(TAG, "State Two being set")
        }
        button3.setOnClickListener {
            presenter.setStateThree()
            Log.i(TAG, "State Three being set")
        }
        button4.setOnClickListener {
            presenter.setStateFour()
            Log.i(TAG, "State Four being set")
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.unbind()
    }

    override fun setTitle(titleResId: Int) {
        titleTextView.text = resources.getString(titleResId)
        Log.d(TAG, "Title updated to: $titleResId")
    }

    override fun setSubTitle(subTitleResId: Int) {
        subTitleTextView.text = resources.getString(subTitleResId)
        Log.d(TAG, "Sub Title updated to: $subTitleResId")
    }

    override fun setDescription(descriptionResId: Int) {
        descriptionTextView.text = resources.getString(descriptionResId)
        Log.d(TAG, "Description updated to: $descriptionResId")
    }

    override fun setSwitch(isSwitched: Boolean) {
        switchWidget.isChecked = isSwitched
        Log.d(TAG, "Switch updated to: $isSwitched")
    }

    override fun setCheckBox(isChecked: Boolean) {
        checkBox.isChecked = isChecked
        Log.d(TAG, "Check box updated to: $isChecked")
    }

    override fun displayLoader(visibility: Int) {
        progressBarWidget.visibility = visibility
        Log.d(TAG, "Progress bar visibility updated to: $visibility")
    }
}
