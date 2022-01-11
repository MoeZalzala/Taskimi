package com.grape.taskimi.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grape.taskimi.data.Note
import com.grape.taskimi.data.repository.NoteRepository
import com.grape.taskimi.util.GetDate
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.*

class NotesViewModel : ViewModel(), NoteInteractionListener {

    private val repository = NoteRepository()

    val newNotesText = MutableLiveData<String>()

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    init {
        loadData()
    }

    fun addNote(){
        viewModelScope.launch {
            newNotesText.value?.let {
                repository.insertNewNote(Note(0, it,GetDate.getCurrentDate(), false))
                }
            newNotesText.value = ""
            }
        }
    fun loadData(){
        viewModelScope.launch {
            repository.getAllNotes().collect {
                _notes.postValue(it)
            }
        }
    }
}