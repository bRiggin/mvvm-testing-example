package com.briggin.mvvmtest

import android.view.View
import androidx.annotation.StringRes

sealed class State(
    @StringRes val title: Int,
    @StringRes val subTitle: Int,
    @StringRes val description: Int,
    val progressBar: Int,
    val switch: Boolean,
    val checkBox: Boolean,
    val showProgress: Int
)

object StateOne: State(
    R.string.state_one_title,
    R.string.sub_title_one,
    R.string.description,
    50,
    true,
    true,
    View.VISIBLE
)

object StateTwo: State(
    R.string.state_two_title,
    R.string.sub_title_two,
    R.string.description,
    0,
    false,
    true,
    View.INVISIBLE
)

object StateThree: State(
    R.string.state_three_title,
    R.string.sub_title_one,
    R.string.description,
    100,
    true,
    false,
    View.VISIBLE
)

object StateFour: State(
    R.string.state_four_title,
    R.string.sub_title_two,
    R.string.description,
    75,
    false,
    false,
    View.INVISIBLE
)