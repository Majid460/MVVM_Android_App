package com.example.mvvmapp.Repository.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
 entities = [User::class],
 version=1,
 exportSchema = true
)
 abstract class UserDatabase:RoomDatabase () {
 abstract fun userdao(): UserDao

 companion object {
  private var INSTANCE: UserDatabase? = null
//  fun getDatabase(context: Context): UserDatabase {
//   if(INSTANCE==null) {
//    synchronized(this) {
//     // Pass the database to the INSTANCE
//     INSTANCE = buildDatabase(context)
//    }
//   }
//   return INSTANCE!!
//  }
  fun getDatabase(context: Context): UserDatabase? {
   INSTANCE?.let {
    return it
   } ?: run {
    synchronized(this) {
     // Pass the database to the INSTANCE
     INSTANCE = buildDatabase(context)
     return INSTANCE
    }
   }
  }
  private fun buildDatabase(context: Context): UserDatabase {
   return Room.databaseBuilder(
    context.applicationContext,
    UserDatabase::class.java,
    "user_database"
   ).allowMainThreadQueries()
    .build()
  }
 }

}