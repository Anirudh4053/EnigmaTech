package com.anirudh.enigmatech.data

import android.view.Window
import android.view.WindowManager

const val NEW_CODE = 12
fun Window.hideStatusBar() {
    this.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
}