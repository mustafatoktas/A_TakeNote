package com.mustafatoktas.nottut.ui.ayarlar

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.dokar.sonner.ToastType
import com.dokar.sonner.rememberToasterState
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.common.Constants
import com.mustafatoktas.nottut.common.OnOFF
import com.mustafatoktas.nottut.common.tarayicidaAc
import com.mustafatoktas.nottut.common.uygulamaAyarlariniAc
import com.mustafatoktas.nottut.ui.ayarlar.components.AyarlarToolbar
import com.mustafatoktas.nottut.ui.ayarlar.components.DialogAyarlariSifirla
import com.mustafatoktas.nottut.ui.ayarlar.components.DialogBaslangicSayfasiSecim
import com.mustafatoktas.nottut.ui.ayarlar.components.DialogDilSecim
import com.mustafatoktas.nottut.ui.ayarlar.components.DialogDinamikRenkSecim
import com.mustafatoktas.nottut.ui.ayarlar.components.DialogGuncellemeDenetle
import com.mustafatoktas.nottut.ui.ayarlar.components.DialogIndirmeBasarisiz
import com.mustafatoktas.nottut.ui.ayarlar.components.DialogParola
import com.mustafatoktas.nottut.ui.ayarlar.components.DialogTemaSecim
import com.mustafatoktas.nottut.ui.ayarlar.components.PermissionDialog
import com.mustafatoktas.nottut.ui.ayarlar.components.StandartSettingRow
import com.mustafatoktas.nottut.ui.ayarlar.viewmodel.AyarlarEvent
import com.mustafatoktas.nottut.ui.ayarlar.viewmodel.AyarlarEventUi
import com.mustafatoktas.nottut.ui.ayarlar.viewmodel.AyarlarViewModel
import com.mustafatoktas.nottut.ui.generalComponents.composables.BottomSnackbar
import kotlinx.coroutines.flow.collectLatest
import kotlin.time.Duration.Companion.milliseconds

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AyarlarScreen(
    modifier: Modifier = Modifier,
    mainNavController: NavHostController,
    context: Context,
    viewModel: AyarlarViewModel,
) {
    val state = viewModel.state.value
    val activity = context as? Activity ?: return

    val toaster = rememberToasterState()
    var ayarlariSifirlaDialog by remember { mutableStateOf(false) }
    var temaDialogGoster by remember { mutableStateOf(false) }
    var dinamikRenkDialogGoster by remember { mutableStateOf(false) }
    var baslangicSayfasiDialogGoster by remember { mutableStateOf(false) }
    var dilDialogGoster by remember { mutableStateOf(false) }
    var guncellemeDialogGoster by remember { mutableStateOf(false) }
    var notificationPermDialogGoster by remember { mutableStateOf(false) }
    var parolaDialog by remember { mutableStateOf(false) }

    val guncellemeDenetle: () -> Unit = {
        guncellemeDialogGoster = true
        viewModel.eventHandle(AyarlarEvent.GuncellemeleriDenetle)
    }

    val notificationPermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            when (isGranted) {
                true -> guncellemeDenetle()
                false -> notificationPermDialogGoster = true
            }
        }
    )

    val ayarlar = listOf(
        // tema
        Triple(
            context.getString(R.string.tema),
            state.tema.getDisplayName(context),
        ) {
            temaDialogGoster = true
        },
        // köşeden köşeye
        Triple(
            context.getString(R.string.koseden_Koseye),
            state.kosedenKoseye.getDisplayName(context),
        ) {
            if (state.kosedenKoseye == OnOFF.Acik) {
                viewModel.eventHandle(AyarlarEvent.KosedenKoseyeAyarla(OnOFF.Kapali))
            } else {
                viewModel.eventHandle(AyarlarEvent.KosedenKoseyeAyarla(OnOFF.Acik))
            }
        },
        // dinamik renk
        Triple(
            context.getString(R.string.dinamik_renk),
            state.dinamikRenk.getDisplayName(context),
        ) {
            dinamikRenkDialogGoster = true
        },
        // başlangıç sayfası
        Triple(
            context.getString(R.string.baslangic_sayfasi),
            state.baslangicSayfasi.getDisplayName(context),
        ) {
            baslangicSayfasiDialogGoster = true
        },
        // dil seçimi
        Triple(
            context.getString(R.string.dil),
            state.dil.getDisplayName(context),
        ) {
            dilDialogGoster = true
        },
        // guncellemeleri denetle
        Triple(
            context.getString(R.string.guncellemeleri_denetle),
            state.gecerliVersiyon,
        ) {
            when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                true -> {
                    when (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                        true -> guncellemeDenetle()
                        false -> notificationPermissionResultLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                    }
                }
                false -> guncellemeDenetle()
            }
        },
        // parola ekle
        Triple(
            context.getString(R.string.parola_ekle),
            Constants.SECRET_STRING,
        ) {
            parolaDialog = true
        },
    )

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is AyarlarEventUi.IndirmeBasliyor -> {
                    toaster.show(
                        message = context.getString(R.string.yeni_surum_downloads_klasorune_indiriliyor),
                        duration = 3300.milliseconds,
                        type = ToastType.Info,
                    )
                }
            }
        }
    }

    BottomSnackbar(toaster)

    Scaffold(
        modifier = modifier,
        topBar = {
            AyarlarToolbar(
                context = context,
                navigationOnClick = {
                    mainNavController.navigateUp()
                },
                ayarlariSifirlaOnClick = {
                    ayarlariSifirlaDialog = true
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(top = 10.dp),
        ) {
            items(ayarlar) { ayar ->
                StandartSettingRow(
                    baslik = ayar.first,
                    icerik = ayar.second,
                ) {
                    ayar.third.invoke()
                }
            }
        }
    }

    if (ayarlariSifirlaDialog) {
        DialogAyarlariSifirla(
            context = context,
            dismissTiklandi = {
                ayarlariSifirlaDialog = false
            },
            sifirlaTiklandi = {
                viewModel.eventHandle(AyarlarEvent.AyarlariSifirla)
                ayarlariSifirlaDialog = false
            }
        )
    }

    if (temaDialogGoster) {
        DialogTemaSecim(
            simdiki = state.tema,
            onDismissRequest = {
                temaDialogGoster = false
            },
            onClickYeni = { secilenTema ->
                viewModel.eventHandle(AyarlarEvent.TemaDegistir(secilenTema))
                temaDialogGoster = false
            }
        )
    }

    if (dinamikRenkDialogGoster) {
        DialogDinamikRenkSecim(
            context = context,
            onDismissRequest = {
                dinamikRenkDialogGoster = false
            },
            onClickYeni = {
                if (state.dinamikRenk == OnOFF.Acik) {
                    viewModel.eventHandle(AyarlarEvent.DinamikRenkAyarla(OnOFF.Kapali))
                } else {
                    viewModel.eventHandle(AyarlarEvent.DinamikRenkAyarla(OnOFF.Acik))
                }
                dinamikRenkDialogGoster = false
            }
        )
    }

    if (baslangicSayfasiDialogGoster) {
        DialogBaslangicSayfasiSecim(
            simdiki = state.baslangicSayfasi,
            onDismissRequest = {
                baslangicSayfasiDialogGoster = false
            },
            onClickYeni = { secilenBaslangicSayfasi ->
                viewModel.eventHandle(AyarlarEvent.BaslangicSayfasiAyarla(secilenBaslangicSayfasi))
                baslangicSayfasiDialogGoster = false
            }
        )
    }

    if (dilDialogGoster) {
        DialogDilSecim(
            simdiki = state.dil,
            onDismissRequest = {
                dilDialogGoster = false
            },
            onClickYeni = { secilenDil ->
                viewModel.eventHandle(AyarlarEvent.DilDegistir(secilenDil))
                dilDialogGoster = false
            }
        )
    }

    if (notificationPermDialogGoster) {
        PermissionDialog(
            onDismissRequest = { notificationPermDialogGoster = false },
            onIzinVerClick = { notificationPermissionResultLauncher.launch(Manifest.permission.POST_NOTIFICATIONS) },
            onAyarlaraGitClick = { activity.uygulamaAyarlariniAc() },
            context = context,
            isPermanentlyDeclined = !activity.shouldShowRequestPermissionRationale(
                Manifest.permission.POST_NOTIFICATIONS
            )
        )
    }

    if (guncellemeDialogGoster) {
        DialogGuncellemeDenetle(
            context = context,
            guncellemeMesaji = state.guncellemeMesaji,
            guncellemeAdresi = state.guncellemeAdresi,
            isLoading = state.isLoading,
            hataVarMi = state.hataVarMi,
            onDismissRequest = { guncellemeDialogGoster = false },
            onSimdiIndirClick = {
                viewModel.eventHandle(AyarlarEvent.GuncellemeIndir)
                guncellemeDialogGoster = false
            },
        )
    }

    if (state.indirmeBasarisizMi) {
        DialogIndirmeBasarisiz(
            context = context,
            onDissmissTiklandi = {
                viewModel.eventHandle(AyarlarEvent.IndirmeBasarisizDialoguKapat)
            },
            onConfirmTiklandi = {
                context.tarayicidaAc(state.releasesSayfasi)
                viewModel.eventHandle(AyarlarEvent.IndirmeBasarisizDialoguKapat)
            },
        )
    }

    if (parolaDialog) {
        DialogParola(
            context = context,
            onConfirmTiklandi = {
                parolaDialog = false
            }
        )
    }
}
