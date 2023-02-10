package com.zsols.notejet.di

import android.content.Context
import androidx.room.Room
import com.zsols.notejet.data.NoteDataBase
import com.zsols.notejet.data.UserNoteTblDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideNotesDao(noteDataBase: NoteDataBase): UserNoteTblDao = noteDataBase.userNoteTBlDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDataBase =
        Room.databaseBuilder(
            context,
            NoteDataBase::class.java,
            "notes_db"
        ).fallbackToDestructiveMigration().build()
}