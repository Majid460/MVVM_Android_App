package com.example.mvvmapp.Repository.Model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll( vararg users:User)
    @Delete
    fun delete(user:User)

    @Query("SELECT * FROM user where id=:id")
    fun getById(id:Int):List<User>

    @Query("SELECT * FROM user ")
    fun getdata():List<User>

    @Query("SELECT * FROM user where city=:city")
    fun getByCity(city:String):List<User>

    @Query("SELECT * FROM user where name=:name")
    fun getByName(name:String):List<User>

    @Query("Delete From user where id=:id ")
    fun deleteId(id:Int)
}