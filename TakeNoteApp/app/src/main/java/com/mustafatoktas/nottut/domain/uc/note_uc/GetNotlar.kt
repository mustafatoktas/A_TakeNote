package com.mustafatoktas.nottut.domain.uc.note_uc

import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.domain.repository.NoteRepository
import com.mustafatoktas.nottut.ui.generalComponents.siralama_siniflari.NotSiralamasi
import com.mustafatoktas.nottut.ui.generalComponents.siralama_siniflari.SiralamaTipi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotlar(
    private val repository: NoteRepository
) {

    operator fun invoke(
        noteSiralamasi: NotSiralamasi = NotSiralamasi.Tarih(SiralamaTipi.ZAsiralama),
        favori: Boolean = false,
    ): Flow<List<Note>> {
        val getirilecekNotlar = when (favori) {
            true -> repository.getFavoriNotlar()
            false -> repository.getNotlar()
        }

        return getirilecekNotlar.map { notes ->
            when (noteSiralamasi.siralamaTipi) {
                is SiralamaTipi.AZsiralama -> {
                    when (noteSiralamasi) {
                        is NotSiralamasi.Baslik -> notes.sortedBy { it.baslik.lowercase() }
                        is NotSiralamasi.Tarih -> notes.sortedBy { it.zamanDamgasi }
                        is NotSiralamasi.Renk -> notes.sortedBy { it.renk }
                    }
                }
                is SiralamaTipi.ZAsiralama -> {
                    when (noteSiralamasi) {
                        is NotSiralamasi.Baslik -> notes.sortedByDescending { it.baslik.lowercase() }
                        is NotSiralamasi.Tarih -> notes.sortedByDescending { it.zamanDamgasi }
                        is NotSiralamasi.Renk -> notes.sortedByDescending { it.renk }
                    }
                }
            }
        }
    }
}
