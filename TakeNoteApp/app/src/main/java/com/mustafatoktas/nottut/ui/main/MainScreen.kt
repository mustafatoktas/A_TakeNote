package com.mustafatoktas.nottut.ui.main

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.common.CihazDurumu
import com.mustafatoktas.nottut.ui.favoriler.viewmodel.FavorilerViewModel
import com.mustafatoktas.nottut.ui.main.components.MainContent
import com.mustafatoktas.nottut.ui.main.components.OtherContent
import com.mustafatoktas.nottut.ui.main.viewmodel.MainViewModel
import com.mustafatoktas.nottut.ui.notlar.viewmodel.NotlarViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    mainNavController: NavHostController,
    subNavController: NavHostController,
    context: Context,
    viewModel: MainViewModel,
    notlarViewModel: NotlarViewModel,
    favorilerViewModel: FavorilerViewModel,
) {
    val state = viewModel.state.value

    when (state.cihazDurumu) {
        CihazDurumu.Rootlu -> OtherContent(
            baslik = context.getString(R.string.root_tespit_edildi),
            icerik = context.getString(R.string.root_icerigi),
            resim = R.drawable.root,
            context = context,
        )
        CihazDurumu.Emulator -> OtherContent(
            baslik = context.getString(R.string.cihaz_bir_emulator_uzerinde_calisiyor),
            icerik = context.getString(R.string.emulator_icerigi),
            resim = R.drawable.emulator,
            context = context,
        )
        CihazDurumu.Normal -> MainContent(
            mainNavController = mainNavController,
            subNavController = subNavController,
            baslangicSayfasi = state.baslangicSayfasi,
            context = context,
            notlarViewModel = notlarViewModel,
            favorilerViewModel = favorilerViewModel,
            viewModel = viewModel,
        )
    }
}
