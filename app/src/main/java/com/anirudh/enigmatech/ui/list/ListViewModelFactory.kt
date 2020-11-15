package com.anirudh.enigmatech.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anirudh.enigmatech.data.repository.MainRepository

class ListViewModelFactory (
        private val  repository: MainRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //will create our view model
        return ListViewModel(repository) as T
    }
}