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
            title.observe(this@MainActivity, Observer {
                titleTextView.text = resources.getString(it)
                Log.d(TAG, "Title updated to: $it")
            })
            subTitle.observe(this@MainActivity, Observer {
                subTitleTextView.text = resources.getString(it)
                Log.d(TAG, "Sub Title updated to: $it")
            })
            description.observe(this@MainActivity, Observer {
                descriptionTextView.text = resources.getString(it)
                Log.d(TAG, "Description updated to: $it")
            })
            progressBar.observe(this@MainActivity, Observer {
                seekBar.progress = it
                Log.d(TAG, "Seek bar progress updated to: $it")
            })
            checkbox.observe(this@MainActivity, Observer {
                checkBox.isChecked = it
                Log.d(TAG, "Check box updated to: $it")
            })
            switch.observe(this@MainActivity, Observer {
                switchWidget.isChecked = it
                Log.d(TAG, "Switch updated to: $it")
            })
            showProgressBar.observe(this@MainActivity, Observer {
                progressBarWidget.visibility = it
                Log.d(TAG, "Progress bar visibility updated to: $it")
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
