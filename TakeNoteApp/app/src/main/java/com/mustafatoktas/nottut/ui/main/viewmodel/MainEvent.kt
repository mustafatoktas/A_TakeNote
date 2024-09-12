package com.mustafatoktas.nottut.ui.main.viewmodel

sealed class MainEvent {
    data class AramaAktifliginiDegistir(val aramaAktifMi: Boolean) : MainEvent()
    data class NotlardaAra(val arananKelime: String) : MainEvent()
    data object BulunanlarListesiniTemizle : MainEvent()
}
