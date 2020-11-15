package com.anirudh.enigmatech.data.repository

import com.anirudh.enigmatech.data.model.User
import io.realm.Realm

class MainRepository() {
    private var realm: Realm = Realm.getDefaultInstance()
    init {
        realm.beginTransaction()
        realm.commitTransaction()
    }

    interface OnData {
        fun onSuccess()
        fun onSuccessAllList(itemArr: List<User>)
        fun onFailure(msg:String)
    }

    fun insert(onData: OnData, addUser: User) {
        val realm: Realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync ({
            val user = it.createObject(User::class.java)
            user.fname = addUser.fname
            user.lname = addUser.lname
            user.age = addUser.age
        },{
            onData.onSuccess()
        },{
            onData.onFailure("Something went wrong")
        })
    }

    fun readData(onData: OnData) {
        val users = realm.where(User::class.java).findAll()
        val userArr = arrayListOf<User>()
        users.forEach {
            userArr.add(it)
        }
        onData.onSuccessAllList(userArr)
    }
}