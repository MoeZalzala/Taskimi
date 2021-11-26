package com.grape.taskimi.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note_table")
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val noteTitle: String,
    val noteDescription: String,
    val isImportant: Boolean
)