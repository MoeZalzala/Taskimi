package com.grape.taskimi.data.repository

import com.grape.taskimi.data.Note
import com.grape.taskimi.data.dataBase.DataBase

class NoteRepository {
    val dao = DataBase.getInstanceWithoutContext().NoteDao()

    suspend fun insertNewNote(note: Note) = dao.insertNewNote(note)

    suspend fun deleteNote(note: Note) = dao.deleteNote(note)

    fun getAllNotes() = dao.getAllNotes()

}