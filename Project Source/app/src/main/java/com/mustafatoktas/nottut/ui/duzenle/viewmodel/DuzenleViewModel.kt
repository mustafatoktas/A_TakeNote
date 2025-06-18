package com.mustafatoktas.nottut.ui.duzenle.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.domain.model.GecersizNotHatasi
import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.domain.uc.app_uc.AppUseCases
import com.mustafatoktas.nottut.domain.uc.note_uc.NotUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DuzenleViewModel @Inject constructor(
    private val noteUseCases: NotUseCases,
    private val appUseCases: AppUseCases,
    private val kaydedilenStateHandle: SavedStateHandle,
) : ViewModel() {

    private object ViewModelConstants {
        const val NOTE_ID_PARAM = "noteIdParam"
        const val DUZENLEME_AKTIF_OLACAK_MI_PARAM = "duzenlemeAktifOlacakMiParam"
    }

    private val _state = mutableStateOf(DuzenleState())
    val state: State<DuzenleState> = _state

    private val _eventFlow = MutableSharedFlow<DuzenleEventUi>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentNoteId: Int? = null

    init {
        noteIdParametresiniAlveIsle()
        duzenlemeAktifOlacakMiParametresiniAlveIsle()
    }

    private fun noteIdParametresiniAlveIsle() {
        kaydedilenStateHandle.get<Int>(ViewModelConstants.NOTE_ID_PARAM)?.let { noteId ->
            if (noteId != -1) {
                viewModelScope.launch(Dispatchers.IO) {
                    noteUseCases.getNot(noteId)?.also { note ->
                        currentNoteId = note.id
                        _state.value = state.value.copy(
                            baslik = note.baslik,
                            icerik = note.icerik,
                            favoriMi = note.isFavori,
                            notRengi = note.renk
                        )
                    }
                }
            } else {
                _state.value = state.value.copy(
                    duzenlemeEtkinMi = true
                )
            }
        }
    }

    private fun duzenlemeAktifOlacakMiParametresiniAlveIsle() {
        viewModelScope.launch(Dispatchers.IO) {
            kaydedilenStateHandle.get<Boolean>(
                ViewModelConstants.DUZENLEME_AKTIF_OLACAK_MI_PARAM
            )?.let { duzenlemeAktifOlacakMi ->
                if (duzenlemeAktifOlacakMi) {
                    _state.value = state.value.copy(
                        duzenlemeEtkinMi = true
                    )
                }
            }
        }
    }

    fun eventHandle(event: DuzenleEvent) {
        when (event) {
            is DuzenleEvent.NotKaydet -> notKaydet()
            is DuzenleEvent.FavoriTiklandi -> favoriTiklandi()
            is DuzenleEvent.YazilanBaslik -> yazilanbaslik(event.baslik)
            is DuzenleEvent.YazilanIcerik -> yazilanIcerik(event.icerik)
            is DuzenleEvent.RenkDegisimi -> notRengiDegistir(event.renk)
            DuzenleEvent.NotDuzenlemeDurumuDegistir -> duzenlemeDurumuDegistir()
        }
    }

    private fun duzenlemeDurumuDegistir() {
        _state.value = state.value.copy(
            duzenlemeEtkinMi = !state.value.duzenlemeEtkinMi
        )
    }

    private fun notRengiDegistir(renk: Int) {
        _state.value = state.value.copy(
            notRengi = renk
        )
    }

    private fun yazilanIcerik(icerik: String) {
        _state.value = state.value.copy(
            icerik = icerik
        )
    }

    private fun yazilanbaslik(baslik: String) {
        _state.value = state.value.copy(
            baslik = baslik
        )
    }

    private fun favoriTiklandi() {
        _state.value = state.value.copy(
            favoriMi = !state.value.favoriMi
        )
    }

    private fun notKaydet() {
        viewModelScope.launch {
            try {
                noteUseCases.ekleNot(
                    Note(
                        id = currentNoteId,
                        baslik = state.value.baslik,
                        icerik = state.value.icerik,
                        isFavori = state.value.favoriMi,
                        zamanDamgasi = System.currentTimeMillis(),
                        renk = state.value.notRengi,
                    )
                )
                _eventFlow.emit(DuzenleEventUi.NotKaydedildi)
            } catch (e: GecersizNotHatasi) {
                _eventFlow.emit(
                    DuzenleEventUi.SnackBarGoster(
                        mesaj = e.message ?: appUseCases.stringResourceSaglayici(R.string.bilinmiyor)
                    )
                )
            }
        }
    }
}
