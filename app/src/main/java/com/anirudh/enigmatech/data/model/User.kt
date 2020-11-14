package com.anirudh.enigmatech.data.model

import io.realm.RealmObject

open class User(
        var fname: String?= null,
        var lname: String?= null,
        var age: Int?= null
) : RealmObject(){}