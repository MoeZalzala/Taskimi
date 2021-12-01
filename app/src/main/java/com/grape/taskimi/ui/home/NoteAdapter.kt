package com.grape.taskimi.ui.home


import com.grape.taskimi.R
import com.grape.taskimi.data.Note
import com.grape.taskimi.ui.base.BaseAdapter
import com.grape.taskimi.ui.base.BaseInteractionListener

class NoteAdapter(items: List<Note>, listener: NoteInteractionListener):
    BaseAdapter<Note>(items, listener) {

    override val layoutId: Int
        get() = R.layout.item_note

}

interface NoteInteractionListener: BaseInteractionListener