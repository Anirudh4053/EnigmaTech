package com.anirudh.enigmatech.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anirudh.enigmatech.data.model.User
import com.anirudh.enigmatech.data.repository.MainRepository
import io.realm.Realm

class ListViewModel(private val repository: MainRepository) : ViewModel() {
    var userList = MutableLiveData<List<User>>()

    fun readData() {
        repository.readData(object : MainRepository.OnData{
            override fun onSuccess() {

            }

            override fun onSuccessAllList(itemArr: List<User>) {
                userList.value = itemArr
            }

            override fun onFailure(msg: String) {

            }

        })
    }
}