package com.mustafatoktas.nottut.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mustafatoktas.nottut.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun ekleYadaGuncelle(note: Note)

    @Delete
    suspend fun sil(note: Note)

    @Query("SELECT * FROM Note")
    fun getNotlar(): Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE isFavori = 1")
    fun getFavoriNotlar(): Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE id = :id")
    suspend fun getNotById(id: Int): Note

    @Query(
        "SELECT * FROM Note WHERE LOWER(baslik) LIKE '%' || LOWER(:kelime) || '%' OR LOWER(icerik) LIKE '%' || LOWER(:kelime) || '%'"
    )
    fun getArananNotlar(kelime: String): Flow<List<Note>>
}
