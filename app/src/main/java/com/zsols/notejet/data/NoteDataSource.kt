package com.zsols.notejet.data

import com.zsols.notejet.model.UserNote

class NoteDataSource{
    fun loadNotes(): List<UserNote>{
        return listOf(
            UserNote(title = "A good Day", desc = "We went on vacation by lake"),
            UserNote(title = "Android Compose", desc = "Wokring on android compose"),
            UserNote(title = "A Movie Day", desc = "Watching a movie with family"),
            UserNote(title = "A good Day", desc = "We went on vacation by lake"),
            UserNote(title = "Android Compose", desc = "Wokring on android compose"),
            UserNote(title = "A Movie Day", desc = "Watching a movie with family"),
            UserNote(title = "A good Day", desc = "We went on vacation by lake"),
            UserNote(title = "Android Compose", desc = "Wokring on android compose"),
            UserNote(title = "A Movie Day", desc = "Watching a movie with family"),
            UserNote(title = "A good Day", desc = "We went on vacation by lake"),
            UserNote(title = "Android Compose", desc = "Wokring on android compose"),
            UserNote(title = "A Movie Day", desc = "Watching a movie with family"),
        )
    }
}