package com.anirudh.enigmatech.ui.detail

import android.util.Log
import com.anirudh.enigmatech.data.model.User
import io.realm.Realm

class DetailRepository() {
    init {

    }
    interface OnData {
        fun onSuccess()
        fun onFailure(msg:String)
    }

    fun insert(onData:OnData,addUser: User) {
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
}