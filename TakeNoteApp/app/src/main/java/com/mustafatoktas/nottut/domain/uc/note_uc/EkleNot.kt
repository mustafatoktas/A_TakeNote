package com.mustafatoktas.nottut.domain.uc.note_uc

import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.domain.model.GecersizNotHatasi
import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.domain.repository.NoteRepository
import com.mustafatoktas.nottut.domain.uc.app_uc.AppUseCases

class EkleNot(
    private val repository: NoteRepository,
    private val appUseCases: AppUseCases,
) {

    @Throws(GecersizNotHatasi::class)
    suspend operator fun invoke(note: Note) {
        if (note.baslik.isBlank()) {
            throw GecersizNotHatasi(appUseCases.stringResourceSaglayici(R.string.baslik_bos_birakilamaz))
        }
        if (note.icerik.isBlank()) {
            throw GecersizNotHatasi(appUseCases.stringResourceSaglayici(R.string.icerik_bos_birakilamaz))
        }
        repository.ekleYadaGuncelle(note)
    }
}
