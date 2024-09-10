package com.mustafatoktas.nottut.ui.ayarlar.viewmodel

import com.mustafatoktas.nottut.common.BaslangicSayfasi
import com.mustafatoktas.nottut.common.Dil
import com.mustafatoktas.nottut.common.OnOFF
import com.mustafatoktas.nottut.common.Tema

sealed class AyarlarEvent {
    data class TemaDegistir(val yeniTema: Tema) : AyarlarEvent()
    data class BaslangicSayfasiAyarla(val yeniBaslangicSayfasi: BaslangicSayfasi) : AyarlarEvent()
    data class KosedenKoseyeAyarla(val yenikosedenKoseye: OnOFF) : AyarlarEvent()
    data class DilDegistir(val yeniDil: Dil) : AyarlarEvent()
    data class DinamikRenkAyarla(val yeniDinamikRenk: OnOFF) : AyarlarEvent()
    data object GuncellemeleriDenetle : AyarlarEvent()
    data object AyarlariSifirla : AyarlarEvent()
    data object GuncellemeIndir : AyarlarEvent()
    data object IndirmeBasarisizDialoguKapat : AyarlarEvent()
}
