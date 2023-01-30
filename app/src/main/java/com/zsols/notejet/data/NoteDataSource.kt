package com.zsols.notejet.data

import com.zsols.notejet.model.NoteData

class NoteDataSource{
    fun loadNotes(): List<NoteData>{
        return listOf(
            NoteData(title = "A good Day", desc = "We went on vacation by lake"),
            NoteData(title = "Android Compose", desc = "Wokring on android compose"),
            NoteData(title = "A Movie Day", desc = "Watching a movie with family"),
            NoteData(title = "A good Day", desc = "We went on vacation by lake"),
            NoteData(title = "Android Compose", desc = "Wokring on android compose"),
            NoteData(title = "A Movie Day", desc = "Watching a movie with family"),
            NoteData(title = "A good Day", desc = "We went on vacation by lake"),
            NoteData(title = "Android Compose", desc = "Wokring on android compose"),
            NoteData(title = "A Movie Day", desc = "Watching a movie with family"),
            NoteData(title = "A good Day", desc = "We went on vacation by lake"),
            NoteData(title = "Android Compose", desc = "Wokring on android compose"),
            NoteData(title = "A Movie Day", desc = "Watching a movie with family"),
        )
    }
}