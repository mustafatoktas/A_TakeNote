package com.mustafatoktas.nottut.ui.ayarlar.viewmodel

import android.os.Build
import android.os.Environment
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ketch.Ketch
import com.ketch.Status
import com.mustafatoktas.nottut.common.BaslangicSayfasi
import com.mustafatoktas.nottut.common.Constants
import com.mustafatoktas.nottut.common.Dil
import com.mustafatoktas.nottut.common.OnOFF
import com.mustafatoktas.nottut.common.Resource
import com.mustafatoktas.nottut.common.Tema
import com.mustafatoktas.nottut.data.local.MyDataStore
import com.mustafatoktas.nottut.domain.uc.app_uc.AppUseCases
import com.mustafatoktas.nottut.domain.uc.github_api_uc.GithubApiUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AyarlarViewModel @Inject constructor(
    private val myDataStore: MyDataStore,
    private val appUseCases: AppUseCases,
    private val githubApiUseCases: GithubApiUseCases,
    private val ketch: Ketch,
) : ViewModel() {

    private val _state = mutableStateOf(AyarlarState())
    val state: State<AyarlarState> = _state

    private val _eventFlow = MutableSharedFlow<AyarlarEventUi>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _state.value = state.value.copy(
                tema = myDataStore.getTema(),
                baslangicSayfasi = myDataStore.getBaslangicSayfasi(),
                kosedenKoseye = myDataStore.getKoseDenKoseYe(),
                gecerliVersiyon = appUseCases.getVersionName.invoke(),
                dil = myDataStore.getDil(),
                dinamikRenk = myDataStore.getDinamikRenk(),
            )
        }
    }

    fun eventHandle(event: AyarlarEvent) {
        when (event) {
            is AyarlarEvent.TemaDegistir -> temaAyarla(event.yeniTema)
            is AyarlarEvent.BaslangicSayfasiAyarla -> baslangicSayfasiAyarla(event.yeniBaslangicSayfasi)
            is AyarlarEvent.KosedenKoseyeAyarla -> kosedenKoseyeAyarla(event.yenikosedenKoseye)
            is AyarlarEvent.DilDegistir -> dilAyarla(event.yeniDil)
            is AyarlarEvent.DinamikRenkAyarla -> dinamikRenkAyarla(event.yeniDinamikRenk)
            AyarlarEvent.AyarlariSifirla -> ayarlariSifirla()
            AyarlarEvent.GuncellemeleriDenetle -> guncellemeleriDenetle()
            AyarlarEvent.GuncellemeIndir -> guncellemeIndir()
            AyarlarEvent.IndirmeBasarisizDialoguKapat -> indirmeBasarisizDialoguKapat()
        }
    }

    private fun indirmeBasarisizDialoguKapat() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                indirmeBasarisizMi = false,
            )
        }
    }

    private fun ayarlariSifirla() {
        viewModelScope.launch(Dispatchers.IO) {
            myDataStore.setBaslangicSayfasi(BaslangicSayfasi.Tum_Notlar)
            myDataStore.setKoseDenKoseYe(OnOFF.Acik)
            myDataStore.setTema(Tema.Sistem)
            myDataStore.setDil(Dil.English)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) myDataStore.setDinamikRenk(OnOFF.Acik)
            _state.value = state.value.copy(
                tema = myDataStore.getTema(),
                baslangicSayfasi = myDataStore.getBaslangicSayfasi(),
                kosedenKoseye = myDataStore.getKoseDenKoseYe(),
                dil = myDataStore.getDil(),
                dinamikRenk = myDataStore.getDinamikRenk()
            )
        }
    }

    private fun temaAyarla(tema: Tema) {
        viewModelScope.launch {
            myDataStore.setTema(tema)
            _state.value = state.value.copy(
                tema = myDataStore.getTema(),
            )
        }
    }

    private fun kosedenKoseyeAyarla(kosedenKoseye: OnOFF) {
        viewModelScope.launch {
            myDataStore.setKoseDenKoseYe(kosedenKoseye)
            _state.value = state.value.copy(
                kosedenKoseye = myDataStore.getKoseDenKoseYe()
            )
        }
    }

    private fun dinamikRenkAyarla(yeniDinamikRenk: OnOFF) {
        viewModelScope.launch {
            myDataStore.setDinamikRenk(yeniDinamikRenk)
            _state.value = state.value.copy(
                dinamikRenk = myDataStore.getDinamikRenk()
            )
        }
    }

    private fun baslangicSayfasiAyarla(baslangicSayfasi: BaslangicSayfasi) {
        viewModelScope.launch {
            myDataStore.setBaslangicSayfasi(baslangicSayfasi)
            _state.value = state.value.copy(
                baslangicSayfasi = myDataStore.getBaslangicSayfasi()
            )
        }
    }

    private fun dilAyarla(dil: Dil) {
        viewModelScope.launch {
            myDataStore.setDil(dil)
            _state.value = state.value.copy(
                dil = myDataStore.getDil()
            )
        }
    }

    private fun guncellemeleriDenetle() {
        viewModelScope.launch {
            githubApiUseCases.checkForUpdates().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            isLoading = result.yukleniyorMu,
                        )
                    }
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            guncellemeMesaji = result.data?.sonVersiyon,
                            guncellemeAdresi = result.data?.indirmeAdresi,
                            hataVarMi = false,
                            dosyaAdi = result.data?.dosyaAdi,
                            releasesSayfasi = result.data?.releasesSayfasi,
                        )
                    }
                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            guncellemeMesaji = result.message,
                            guncellemeAdresi = null,
                            hataVarMi = true,
                        )
                    }
                }
            }
        }
    }

    private fun guncellemeIndir() {
        ketch.download(
            tag = state.value.dosyaAdi ?: Constants.UNKNOWN_STRING,
            url = state.value.guncellemeAdresi ?: Constants.EMPTY_STRING,
            fileName = state.value.dosyaAdi ?: Constants.UNKNOWN_STRING,
            path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path
        )
        viewModelScope.launch {
            _eventFlow.emit(AyarlarEventUi.IndirmeBasliyor)
        }
        indirmeyiGozlemle()
    }

    private fun indirmeyiGozlemle() {
        viewModelScope.launch {
            ketch.observeDownloadByTag(state.value.dosyaAdi ?: Constants.UNKNOWN_STRING).collect {
                    downloadModel ->
                when (downloadModel.isEmpty()) {
                    true -> return@collect
                    false -> {
                        when (downloadModel.first().status) {
                            Status.FAILED -> {
                                _state.value = state.value.copy(
                                    indirmeBasarisizMi = true,
                                )
                            }
                            Status.QUEUED -> {}
                            Status.STARTED -> {}
                            Status.PROGRESS -> {}
                            Status.SUCCESS -> {
                                _state.value = state.value.copy(
                                    indirmeBasarisizMi = false,
                                )
                            }
                            Status.CANCELLED -> {}
                            Status.PAUSED -> {}
                            Status.DEFAULT -> {}
                        }
                    }
                }
            }
        }
    }
}
