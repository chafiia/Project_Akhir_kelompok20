package com.example.project.dat.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class user(
    @PrimaryKey(autoGenerate = true) var uid: Int? = null,
    @ColumnInfo(name = "timeStart") var timeStart: String? = null,
    @ColumnInfo(name = "title") var title: String? = null,
    @ColumnInfo(name = "desc") var desc: String? = null,
    @ColumnInfo(name = "isDone") var isDone: Boolean = false
)
