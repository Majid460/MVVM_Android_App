package com.example.mvvmapp.Repository

import androidx.lifecycle.LiveData
import com.example.mvvmapp.Repository.Model.User
import com.example.mvvmapp.Repository.Model.UserDao

class UserRepository (private val userDao: UserDao) {
    fun insertAll(user: User){
        userDao.insertAll(user)
    }
    fun getdata():List<User>
    {
        return userDao.getdata()
    }
    fun getById(id:Int):List<User>{
        return userDao.getById(id)
    }
    fun getByName(name:String):List<User>{
        return userDao.getByName(name)
    }
    fun getByCity(city:String):List<User>{
        return userDao.getByCity(city)
    }
    fun deleteId(id:Int)
    {
        return userDao.deleteId(id)
    }
}