package com.anirudh.enigmatech

import android.app.Application
import com.anirudh.enigmatech.data.repository.MainRepository
import com.anirudh.enigmatech.ui.detail.DetailViewModelFactory
import com.anirudh.enigmatech.ui.list.ListViewModelFactory
import io.realm.Realm
import io.realm.RealmConfiguration
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)
    }
    override val kodein =  Kodein.lazy{
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { MainRepository() }
        bind() from provider { ListViewModelFactory(instance()) }
        bind() from provider { DetailViewModelFactory(instance()) }
    }
}