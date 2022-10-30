package com.jfalck.mooviz.common

import android.view.View

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}

fun View.setVisible(isVisible: Boolean) {
    if (isVisible) {
        makeVisible()
    } else {
        makeGone()
    }
}