package com.mustafatoktas.nottut.ui.notlar.viewmodel

import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.ui.generalComponents.NotlarBaseState
import com.mustafatoktas.nottut.ui.generalComponents.siralama_siniflari.NotSiralamasi
import com.mustafatoktas.nottut.ui.generalComponents.siralama_siniflari.SiralamaTipi

data class NotlarState(
    override val siralamaBolumuGorunurMu: Boolean = false,
    override val notlar: List<Note> = emptyList(),
    override val notSiralamasi: NotSiralamasi = NotSiralamasi.Tarih(SiralamaTipi.ZAsiralama),
) : NotlarBaseState
