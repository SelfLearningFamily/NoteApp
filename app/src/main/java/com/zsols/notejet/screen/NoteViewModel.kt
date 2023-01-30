package com.zsols.notejet.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.zsols.notejet.data.NoteDataSource
import com.zsols.notejet.model.NoteData

class NoteViewModel: ViewModel() {
    var noteList = mutableStateListOf<NoteData>()

    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note : NoteData){
        noteList.add(note)
    }

    fun removeNote(note : NoteData){
        noteList.remove(note)
    }

    fun getAllNotes() : List<NoteData>{
        return noteList
    }
}