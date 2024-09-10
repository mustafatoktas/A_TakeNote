package com.mustafatoktas.nottut.ui.favoriler.viewmodel

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
class FavorilerViewModel @Inject constructor(
    private val noteUseCases: NotUseCases
) : ViewModel(), NotlarBaseViewModel {

    private val _state = mutableStateOf(FavorilerState())
    val state: State<FavorilerState> = _state

    private val _eventFlow = MutableSharedFlow<FavorilerEventUi>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var getNotesJob: Job? = null

    private var sonZamandaSilinenNot: Note? = null

    init {
        getFavoriNotlar(NotSiralamasi.Tarih(SiralamaTipi.ZAsiralama))
    }

    override fun eventHandle(event: NotlarBaseEvent) {
        when (event) {
            is NotlarBaseEvent.SilNote -> notSil(event.note)
            is NotlarBaseEvent.GeriKaydetNot -> silmeyiGeriAl()
            is NotlarBaseEvent.Siralama -> notlariSirala(event.notSiralamasi)
            NotlarBaseEvent.ToggleSiralamaBolumu -> siralamaSectionGosterGizle()
        }
    }

    private fun silmeyiGeriAl() {
        viewModelScope.launch {
            noteUseCases.ekleNot(sonZamandaSilinenNot ?: return@launch)
            sonZamandaSilinenNot = null
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

        getFavoriNotlar(notSiralamasi)
    }

    private fun notSil(note: Note) {
        viewModelScope.launch {
            noteUseCases.silNot(note)
            sonZamandaSilinenNot = note
            _eventFlow.emit(FavorilerEventUi.SnackBarGoster)
        }
    }

    private fun getFavoriNotlar(notSiralamasi: NotSiralamasi) {
        getNotesJob?.cancel()

        getNotesJob = noteUseCases.getNotlar(notSiralamasi, favori = true)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notlar = notes,
                    notSiralamasi = notSiralamasi
                )
            }.launchIn(viewModelScope)
    }
}
