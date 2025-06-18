package com.mustafatoktas.nottut.ui.duzenle.viewmodel

import androidx.compose.ui.graphics.toArgb
import com.mustafatoktas.nottut.domain.model.Note

data class DuzenleState(
    val baslik: String = "",
    val icerik: String = "",
    val favoriMi: Boolean = false,
    val notRengi: Int = Note.notRenkleri.random().toArgb(),
    val duzenlemeEtkinMi: Boolean = false,
)
