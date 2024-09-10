package com.mustafatoktas.nottut.ui.notlar.viewmodel

sealed class NotlarEventUi {
    data object SnackBarGoster : NotlarEventUi()
}
