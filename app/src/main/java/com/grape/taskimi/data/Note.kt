package com.grape.taskimi.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Note_Table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id:Long,
    @ColumnInfo(name = "Content") val content: String,
    @ColumnInfo(name = "Date") val date: String,
    @ColumnInfo(name = "Important") val important: Boolean
)