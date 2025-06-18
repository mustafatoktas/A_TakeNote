package com.mustafatoktas.nottut.ui.generalComponents

import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.ui.generalComponents.siralama_siniflari.NotSiralamasi

sealed class NotlarBaseEvent {
    data class SilNote(val note: Note) : NotlarBaseEvent()
    data object GeriKaydetNot : NotlarBaseEvent()
    data class Siralama(val notSiralamasi: NotSiralamasi) : NotlarBaseEvent()
    object ToggleSiralamaBolumu : NotlarBaseEvent()
}
