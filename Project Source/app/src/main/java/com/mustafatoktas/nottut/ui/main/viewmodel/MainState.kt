package com.mustafatoktas.nottut.ui.main.viewmodel

import com.mustafatoktas.nottut.common.BaslangicSayfasi
import com.mustafatoktas.nottut.common.CihazDurumu
import com.mustafatoktas.nottut.domain.model.Note

data class MainState(
    val cihazDurumu: CihazDurumu = CihazDurumu.Normal,
    val baslangicSayfasi: BaslangicSayfasi = BaslangicSayfasi.Tum_Notlar,
    val aramaAktifMi: Boolean = false,
    val bulunanlarListesi: List<Note> = emptyList()
)
