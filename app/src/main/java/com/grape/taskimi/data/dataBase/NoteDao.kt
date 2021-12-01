package com.grape.taskimi.data.dataBase

import androidx.room.*
import com.grape.taskimi.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNewNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM Note_Table")
    fun getAllNotes(): Flow<List<Note>>
}