package com.mustafatoktas.nottut.ui.hakkinda.viewmodel

import com.mustafatoktas.nottut.common.Constants

data class HakkindaState(
    val versiyon: String = Constants.EMPTY_STRING,
    val telefonModeli: String = Constants.EMPTY_STRING,
    val isletimSistemi: String = Constants.EMPTY_STRING,
)
