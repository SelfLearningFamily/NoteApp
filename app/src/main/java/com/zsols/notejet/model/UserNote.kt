package com.zsols.notejet.model

import androidx.room.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.util.*

@TypeConverters(DateConverter::class)
@Entity(tableName = "notes_tbl")
data class UserNote(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_desc")
    val desc: String,

    @ColumnInfo(name = "note_entry_date")
    val entryDate: OffsetDateTime? = OffsetDateTime.now()
    )
