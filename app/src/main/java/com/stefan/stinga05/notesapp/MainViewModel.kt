package com.stefan.stinga05.notesapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.stefan.stinga05.notesapp.database.room.AppRoomDatabase
import com.stefan.stinga05.notesapp.database.room.repository.RoomRepository
import com.stefan.stinga05.notesapp.utils.REPOSITORY
import com.stefan.stinga05.notesapp.utils.TYPE_ROOM

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
        }
    }
}