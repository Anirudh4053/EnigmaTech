package com.anirudh.enigmatech.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anirudh.enigmatech.data.repository.MainRepository

class DetailViewModelFactory (
    private val  repository: MainRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //will create our view model
        return DetailViewModel(repository) as T
    }
}