package com.briggin.mvvmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.main_activity.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        with(viewModel) {
            state.observe(this@MainActivity, Observer {
                Log.d(TAG, "State updated to: $it")
                titleTextView.text = resources.getString(it.title)
                subTitleTextView.text = resources.getString(it.subTitle)
                descriptionTextView.text = resources.getString(it.description)
                seekBar.progress = it.progressBar
                checkBox.isChecked = it.checkBox
                switchWidget.isChecked = it.switch
                progressBarWidget.visibility = it.showProgress
            })
        }

        button.setOnClickListener {
            viewModel.setStateOne()
            Log.i(TAG, "State One being set")
        }
        button2.setOnClickListener {
            viewModel.setStateTwo()
            Log.i(TAG, "State Two being set")
        }
        button3.setOnClickListener {
            viewModel.setStateThree()
            Log.i(TAG, "State Three being set")
        }
        button4.setOnClickListener {
            viewModel.setStateFour()
            Log.i(TAG, "State Four being set")
        }
    }
}
