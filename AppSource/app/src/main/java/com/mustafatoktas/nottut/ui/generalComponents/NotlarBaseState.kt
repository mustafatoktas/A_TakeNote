package com.mustafatoktas.nottut.ui.generalComponents

import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.ui.generalComponents.siralama_siniflari.NotSiralamasi

interface NotlarBaseState {
    val siralamaBolumuGorunurMu: Boolean
    val notlar: List<Note>
    val notSiralamasi: NotSiralamasi
}
