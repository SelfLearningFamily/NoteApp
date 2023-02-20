package com.zsols.notejet.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zsols.notejet.data.NoteDataSource
import com.zsols.notejet.model.UserNote
import com.zsols.notejet.repo.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repo : NoteRepo): ViewModel() {
    var _noteList = MutableStateFlow<List<UserNote>>(emptyList())
    var noteList = _noteList.asStateFlow()

    init {
      //  noteList.addAll(NoteDataSource().loadNotes())
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllNotes().distinctUntilChanged()
                .collect{ listOfNote ->
                    if(listOfNote.isNotEmpty())
                        _noteList.value = listOfNote
                    else
                        Log.d("noteListFlow", "list is empty")
                }
        }
    }

    fun addNote(note : UserNote) = viewModelScope.launch { repo.addNote(note) }

    fun removeNote(note : UserNote) = viewModelScope.launch { repo.deleteNote(note) }
    fun updateNote(note : UserNote) = viewModelScope.launch { repo.updateNote(note) }

    fun getAllNotes() : StateFlow<List<UserNote>> {
        return noteList
    }
}