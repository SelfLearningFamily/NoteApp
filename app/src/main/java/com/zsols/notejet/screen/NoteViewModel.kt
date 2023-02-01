package com.zsols.notejet.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.zsols.notejet.data.NoteDataSource
import com.zsols.notejet.model.UserNote

class NoteViewModel: ViewModel() {
    var noteList = mutableStateListOf<UserNote>()

    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note : UserNote){
        noteList.add(note)
    }

    fun removeNote(note : UserNote){
        noteList.remove(note)
    }

    fun getAllNotes() : List<UserNote>{
        return noteList
    }
}