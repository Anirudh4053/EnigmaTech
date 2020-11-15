package com.anirudh.enigmatech.ui.list

interface ListListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}