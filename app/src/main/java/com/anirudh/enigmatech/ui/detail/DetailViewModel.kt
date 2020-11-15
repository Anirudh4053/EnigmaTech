package com.anirudh.enigmatech.ui.detail

import androidx.lifecycle.ViewModel
import com.anirudh.enigmatech.data.model.User
import com.anirudh.enigmatech.data.repository.MainRepository

class DetailViewModel(private val detailRepository: MainRepository): ViewModel() {
    var detailListener: DetailListener? = null
    fun insertRecord(userData:User) {
        detailListener?.onStarted()
        detailRepository.insert(object : MainRepository.OnData{
            override fun onSuccess() {
                detailListener?.onSuccess()
            }

            override fun onSuccessAllList(itemArr: List<User>) {

            }

            override fun onFailure(msg: String) {
                detailListener?.onFailure(msg)
            }

        },userData)
    }

}