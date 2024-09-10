package com.mustafatoktas.nottut.domain.repository

import com.mustafatoktas.nottut.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun ekleYadaGuncelle(note: Note)

    suspend fun sil(note: Note)

    fun getNotlar(): Flow<List<Note>>

    fun getFavoriNotlar(): Flow<List<Note>>

    suspend fun getNotById(id: Int): Note
}
