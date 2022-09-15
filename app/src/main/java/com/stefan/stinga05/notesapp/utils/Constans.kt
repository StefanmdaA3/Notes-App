package com.stefan.stinga05.notesapp.utils

import com.stefan.stinga05.notesapp.database.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY: DatabaseRepository
lateinit var LOGIN: String
lateinit var PASSWORD: String

object Constants {
    object Keys {
        const val NOTE_DATABASE = "notes_database"
        const val NOTE_TABLE = "notes_table"
    }

    object Screens {
        const val START_SCREEN = "start_screen"
        const val ADD_SCREEN = "add_screen"
        const val MAIN_SCREEN = "main_screen"
        const val NOTE_SCREEN = "note_screen"
    }
}