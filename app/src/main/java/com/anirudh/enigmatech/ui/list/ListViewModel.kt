package com.anirudh.enigmatech.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anirudh.enigmatech.data.model.User
import io.realm.Realm

class ListViewModel : ViewModel() {
    private var realm: Realm = Realm.getDefaultInstance()
    var userList = MutableLiveData<List<User>>()

    init {
        realm.beginTransaction()
        realm.commitTransaction()
        //readData()
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun readData() {
        val users = realm.where(User::class.java).findAll()
        val userArr = arrayListOf<User>()
        users.forEach {
            userArr.add(it)
        }
        userList.value = userArr
    }
}