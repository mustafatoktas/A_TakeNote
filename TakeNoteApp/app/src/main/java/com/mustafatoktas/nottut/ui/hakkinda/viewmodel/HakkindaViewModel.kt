package com.mustafatoktas.nottut.ui.hakkinda.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafatoktas.nottut.domain.uc.app_uc.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HakkindaViewModel @Inject constructor(
    private val appUseCases: AppUseCases
) : ViewModel() {

    private val _state = mutableStateOf(HakkindaState())
    val state: State<HakkindaState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = state.value.copy(
                versiyon = getVersiyonNumber(),
                telefonModeli = getPhoneModelName(),
                isletimSistemi = getOperationSystemName()
            )
        }
    }

    private fun getVersiyonNumber(): String {
        val versiyon = appUseCases.getVersionName.invoke()
        return versiyon.substring(1) // İlk karakteri atlar ve kalan kısmı döner
    }

    private fun getPhoneModelName(): String {
        return appUseCases.getPhoneModelName.invoke()
    }

    private fun getOperationSystemName(): String {
        return appUseCases.getOperationSystemName.invoke()
    }
}
