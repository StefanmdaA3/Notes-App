package com.stefan.stinga05.notesapp.database.room.repository

import androidx.lifecycle.LiveData
import com.stefan.stinga05.notesapp.database.DatabaseRepository
import com.stefan.stinga05.notesapp.database.room.dao.NoteRoomDao
import com.stefan.stinga05.notesapp.model.Note

class RoomRepository(private val noteRoomDao: NoteRoomDao): DatabaseRepository {

    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note)
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.updateNote(note)
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.deleteNote(note)
    }
}