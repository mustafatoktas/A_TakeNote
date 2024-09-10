package com.mustafatoktas.nottut.ui.duzenle.viewmodel

sealed class DuzenleEvent {
    data object NotKaydet : DuzenleEvent()
    data object FavoriTiklandi : DuzenleEvent()
    data class YazilanBaslik(val baslik: String) : DuzenleEvent()
    data class YazilanIcerik(val icerik: String) : DuzenleEvent()
    data class RenkDegisimi(val renk: Int) : DuzenleEvent()
    data object NotDuzenlemeDurumuDegistir : DuzenleEvent()
}
