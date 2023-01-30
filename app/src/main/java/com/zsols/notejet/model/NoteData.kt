package com.zsols.notejet.model

import java.time.LocalDateTime
import java.util.UUID

data class NoteData(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val desc: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
    )
