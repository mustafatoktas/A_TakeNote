package com.mustafatoktas.nottut.ui.notlar.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.domain.uc.note_uc.NotUseCases
import com.mustafatoktas.nottut.ui.generalComponents.NotlarBaseEvent
import com.mustafatoktas.nottut.ui.generalComponents.NotlarBaseViewModel
import com.mustafatoktas.nottut.ui.generalComponents.siralama_siniflari.NotSiralamasi
import com.mustafatoktas.nottut.ui.generalComponents.siralama_siniflari.SiralamaTipi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotlarViewModel @Inject constructor(
    private val noteUseCases: NotUseCases
) : ViewModel(), NotlarBaseViewModel {

    private val _state = mutableStateOf(NotlarState())
    val state: State<NotlarState> = _state

    private val _eventFlow = MutableSharedFlow<NotlarEventUi>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var getNotesJob: Job? = null

    private var sonZamandaSilinenNot: Note? = null

    init {
        getNotlar(NotSiralamasi.Tarih(SiralamaTipi.ZAsiralama))
    }

    override fun eventHandle(event: NotlarBaseEvent) {
        when (event) {
            is NotlarBaseEvent.SilNote -> notSil(event.note)
            is NotlarBaseEvent.GeriKaydetNot -> silmeyiGeriAl()
            is NotlarBaseEvent.Siralama -> notlariSirala(event.notSiralamasi)
            NotlarBaseEvent.ToggleSiralamaBolumu -> siralamaSectionGosterGizle()
        }
    }

    fun siralamaSectionGosterGizle() {
        if (_state.value.notlar.isNotEmpty()) {
            _state.value = state.value.copy(
                siralamaBolumuGorunurMu = !state.value.siralamaBolumuGorunurMu
            )
        } else {
            _state.value = state.value.copy(
                siralamaBolumuGorunurMu = !state.value.siralamaBolumuGorunurMu
            )
        }
    }

    private fun notlariSirala(notSiralamasi: NotSiralamasi) {
        if (state.value.notSiralamasi::class == notSiralamasi::class &&
            state.value.notSiralamasi.siralamaTipi == notSiralamasi.siralamaTipi
        ) {
            return
        }

        getNotlar(notSiralamasi)
    }

    private fun silmeyiGeriAl() {
        viewModelScope.launch {
            noteUseCases.ekleNot(sonZamandaSilinenNot ?: return@launch)
            sonZamandaSilinenNot = null
        }
    }

    private fun notSil(note: Note) {
        viewModelScope.launch {
            noteUseCases.silNot(note)
            sonZamandaSilinenNot = note
            _eventFlow.emit(NotlarEventUi.SnackBarGoster)
        }
    }

    private fun getNotlar(notSiralamasi: NotSiralamasi) {
        getNotesJob?.cancel()

        getNotesJob = noteUseCases.getNotlar(notSiralamasi)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notlar = notes,
                    notSiralamasi = notSiralamasi
                )
            }.launchIn(viewModelScope)
    }
}
