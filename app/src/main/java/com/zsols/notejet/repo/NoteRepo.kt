package com.zsols.notejet.repo

import com.zsols.notejet.data.UserNoteTblDao
import com.zsols.notejet.model.UserNote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepo @Inject constructor(private val userNoteTblDao: UserNoteTblDao) {
    suspend fun addNote(userNote: UserNote) = userNoteTblDao.insert(userNote)
    suspend fun updateNote(userNote: UserNote) = userNoteTblDao.update(userNote)
    suspend fun deleteNote(userNote: UserNote) = userNoteTblDao.deleteNote(userNote)
    suspend fun deleteAllNote() = userNoteTblDao.deleteAll()
    fun getAllNotes() : Flow<List<UserNote>> = userNoteTblDao.getAllNote().flowOn(Dispatchers.IO).conflate()
}