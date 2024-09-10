package com.mustafatoktas.nottut.ui.duzenle.viewmodel

sealed class DuzenleEventUi {
    data class SnackBarGoster(val mesaj: String) : DuzenleEventUi()
    data object NotKaydedildi : DuzenleEventUi()
}
