package com.mustafatoktas.nottut.data.repositoryImpl

import com.mustafatoktas.nottut.data.local.NoteDao
import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotlar(): Flow<List<Note>> = dao.getNotlar()

    override fun getFavoriNotlar(): Flow<List<Note>> = dao.getFavoriNotlar()

    override suspend fun getNotById(id: Int): Note = dao.getNotById(id)

    override suspend fun ekleYadaGuncelle(note: Note) = dao.ekleYadaGuncelle(note)

    override suspend fun sil(note: Note) = dao.sil(note)

    override fun getArananNotlar(kelime: String): Flow<List<Note>> = dao.getArananNotlar(kelime)
}
