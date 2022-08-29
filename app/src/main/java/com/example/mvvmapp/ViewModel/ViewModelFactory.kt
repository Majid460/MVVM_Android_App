package com.example.mvvmapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapp.Repository.UserRepository


class ViewModelFactory(private val userRepository: UserRepository?) :ViewModelProvider.Factory{
     override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(userRepository) as T
    }
}