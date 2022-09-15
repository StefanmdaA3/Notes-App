package com.stefan.stinga05.notesapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.stefan.stinga05.notesapp.database.firebase.FirebaseRepository
import com.stefan.stinga05.notesapp.database.room.AppRoomDatabase
import com.stefan.stinga05.notesapp.database.room.repository.RoomRepository
import com.stefan.stinga05.notesapp.model.Note
import com.stefan.stinga05.notesapp.utils.REPOSITORY
import com.stefan.stinga05.notesapp.utils.TYPE_FIREBASE
import com.stefan.stinga05.notesapp.utils.TYPE_ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        Log.d("checkData", "MainViewModel init database with type: $type")
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }

            TYPE_FIREBASE -> {
                REPOSITORY = FirebaseRepository()
                REPOSITORY.connectToDatabase(
                    { onSuccess() },
                    { Log.d("checkData","Error: $it")}
                )
            }
        }
    }

    fun addNote(note: Note, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.create(note = note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun updateNote(note: Note, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.create(note = note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteNote(note: Note, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.delete(note = note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllNote() = REPOSITORY.readAll
}