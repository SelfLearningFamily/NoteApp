package com.zsols.notejet.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zsols.notejet.model.UserNote

@Database(entities = [UserNote::class], version = 1, exportSchema = false)
abstract class NoteDataBase : RoomDatabase() {
abstract fun noteDao(): NoteDataBaseDao
}