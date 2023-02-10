package com.zsols.notejet.data

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.compose.runtime.Composable
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.zsols.notejet.model.UserNote
import com.zsols.notejet.model.abc
import kotlinx.coroutines.flow.Flow

@Dao
interface UserNoteTblDao {

    @Query("SELECT * from notes_tbl")
    fun getAllNote(): Flow<List<UserNote>>

    @Query("SELECT * from notes_tbl where id = :id")
    suspend fun getNoteById(id: String): UserNote

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: UserNote)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE from notes_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: UserNote)
}


@Composable
fun test(){
    abc()
}
