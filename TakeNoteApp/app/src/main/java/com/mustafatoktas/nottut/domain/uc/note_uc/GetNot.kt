package com.mustafatoktas.nottut.domain.uc.note_uc

import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.domain.repository.NoteRepository

class GetNot(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNotById(id)
    }
}
