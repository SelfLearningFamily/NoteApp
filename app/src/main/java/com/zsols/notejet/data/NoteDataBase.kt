package com.zsols.notejet.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zsols.notejet.model.UserNote
//would create the database
@Database(entities = [UserNote::class], version = 1, exportSchema = false)
abstract class NoteDataBase : RoomDatabase() {
abstract fun userNoteTBlDao(): UserNoteTblDao
}