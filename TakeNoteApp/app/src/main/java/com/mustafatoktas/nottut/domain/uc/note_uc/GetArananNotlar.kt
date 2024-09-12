package com.mustafatoktas.nottut.domain.uc.note_uc

import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetArananNotlar(
    private val repository: NoteRepository
) {
    operator fun invoke(arananKelime: String): Flow<List<Note>> {
        return repository.getArananNotlar(arananKelime).map { notes ->
            notes.sortedByDescending { it.zamanDamgasi }
        }
    }
}
