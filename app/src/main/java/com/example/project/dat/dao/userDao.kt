package com.example.project.dat.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.project.dat.entitiy.user

@Dao
interface userDao {
    //getAll ambil semua data dari table user
    @Query("SELECT * FROM user")
    fun getAll(): List<user>

    //disini untuk memanggil/mengambil data yang dimana di ambil drai user id
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<user>

    @Insert
    fun insertAll(vararg users: user)

    @Delete
    fun delete(user: user)

    @Query("SELECT * FROM user WHERE uid = :uid")
    fun get(uid: Int) : user

    @Update
    fun update(user: user)
}