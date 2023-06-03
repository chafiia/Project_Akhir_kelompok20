package com.example.project.dat

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project.dat.dao.userDao
import com.example.project.dat.entitiy.user

@Database(entities = [user::class], version = 1)
abstract class AppData : RoomDatabase() {
    abstract fun userDao():userDao

    companion object{
        private var instance: AppData? = null

        fun getInstance(context: Context): AppData{
            if (instance==null){
                instance = Room.databaseBuilder(context, AppData::class.java, "app-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }

}