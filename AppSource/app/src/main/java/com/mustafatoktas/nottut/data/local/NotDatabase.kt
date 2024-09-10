package com.mustafatoktas.nottut.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mustafatoktas.nottut.domain.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = true)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val ROOM_VERITABANI_ADI = "notes_db"
    }
}
