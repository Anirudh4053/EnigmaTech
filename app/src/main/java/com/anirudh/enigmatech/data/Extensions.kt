package com.anirudh.enigmatech.data

import android.app.Activity
import android.content.Context
import android.view.Window
import android.view.WindowManager
import android.widget.Toast

const val NEW_CODE = 12
fun Window.hideStatusBar() {
    this.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
}
fun Context.showToast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}
fun validateError(activity: Activity, inputValue:String, label:String) : Boolean {
    if(inputValue.isNullOrEmpty()){
        activity.showToast("Enter valid $label")
        return false
    }
    return true
}