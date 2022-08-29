package com.example.mvvmapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmapp.Repository.Model.User
import com.example.mvvmapp.Repository.UserRepository

class UserViewModel(private val userRepository: UserRepository?):ViewModel() {
    fun insertAll(user: User){
        userRepository?.insertAll(user)
    }
    fun getdata(): List<User>?
    {
        return userRepository?.getdata()
    }
    fun getById(id:Int):List<User>?{
        return userRepository?.getById(id)
    }
    fun getByName(name:String):List<User>?{
        return userRepository?.getByName(name)
    }
    fun getByCity(city:String):List<User>?{
        return userRepository?.getByCity(city)
    }
    fun deleteId(id:Int)
    {
        userRepository?.deleteId(id)
    }
}