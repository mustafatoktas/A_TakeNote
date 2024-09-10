package com.mustafatoktas.nottut.ui.main.viewmodel

import com.mustafatoktas.nottut.common.BaslangicSayfasi
import com.mustafatoktas.nottut.common.CihazDurumu

data class MainState(
    val cihazDurumu: CihazDurumu = CihazDurumu.Normal,
    val baslangicSayfasi: BaslangicSayfasi = BaslangicSayfasi.Tum_Notlar,
)
