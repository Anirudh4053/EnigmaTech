package com.anirudh.enigmatech.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailViewModelFactory (
    private val  repository: DetailRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //will create our view model
        return DetailViewModel(repository) as T
    }
}