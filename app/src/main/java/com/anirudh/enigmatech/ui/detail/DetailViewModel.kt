package com.anirudh.enigmatech.ui.detail

import androidx.lifecycle.ViewModel
import com.anirudh.enigmatech.data.model.User

class DetailViewModel(private val detailRepository: DetailRepository): ViewModel() {
    var detailListener: DetailListener? = null
    var mainList: DetailListener? = null
    fun insertRecord(userData:User) {
        detailListener?.onStarted()
        detailRepository.insert(object :DetailRepository.OnData{
            override fun onSuccess() {
                detailListener?.onSuccess()
            }

            override fun onFailure(msg: String) {
                detailListener?.onFailure(msg)
            }

        },userData)
    }

}