package com.anirudh.enigmatech.ui.detail

interface DetailListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}