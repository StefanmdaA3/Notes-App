package com.stefan.stinga05.notesapp.database

import androidx.lifecycle.LiveData
import com.stefan.stinga05.notesapp.model.Note

interface DatabaseRepository {

    val readAll: LiveData<List<Note>>

    suspend fun create(note: Note, onSuccess: () -> Unit)

    suspend fun update(note: Note, onSuccess: () -> Unit)

    suspend fun delete(note: Note, onSuccess: () -> Unit)
}