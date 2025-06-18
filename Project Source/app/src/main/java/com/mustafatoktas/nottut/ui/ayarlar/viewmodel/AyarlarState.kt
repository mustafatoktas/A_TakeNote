package com.mustafatoktas.nottut.ui.ayarlar.viewmodel

import com.mustafatoktas.nottut.common.BaslangicSayfasi
import com.mustafatoktas.nottut.common.Constants
import com.mustafatoktas.nottut.common.Dil
import com.mustafatoktas.nottut.common.OnOFF
import com.mustafatoktas.nottut.common.Tema

data class AyarlarState(
    val tema: Tema = Tema.Sistem,
    val baslangicSayfasi: BaslangicSayfasi = BaslangicSayfasi.Tum_Notlar,
    val kosedenKoseye: OnOFF = OnOFF.Acik,
    val gecerliVersiyon: String = Constants.EMPTY_STRING,
    val dil: Dil = Dil.English,
    val dinamikRenk: OnOFF = OnOFF.Acik,

    val guncellemeMesaji: String? = null,
    val guncellemeAdresi: String? = null,
    val isLoading: Boolean = false,
    val hataVarMi: Boolean = false,
    val dosyaAdi: String? = null,
    val releasesSayfasi: String? = null,
    val indirmeBasarisizMi: Boolean = false,
)
