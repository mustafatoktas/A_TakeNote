package com.mustafatoktas.nottut.ui.main.components

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dokar.sonner.ToastType
import com.dokar.sonner.rememberToasterState
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.common.Constants
import com.mustafatoktas.nottut.common.sayfayaGit
import com.mustafatoktas.nottut.ui.generalComponents.composables.BottomSnackbar
import com.mustafatoktas.nottut.ui.generalComponents.composables.NoteCard
import com.mustafatoktas.nottut.ui.main.viewmodel.MainEvent
import com.mustafatoktas.nottut.ui.main.viewmodel.MainState
import com.mustafatoktas.nottut.ui.main.viewmodel.MainViewModel
import com.mustafatoktas.nottut.ui.navigation.Destination
import kotlin.time.Duration.Companion.milliseconds

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotlardaAra(
    viewModel: MainViewModel,
    state: MainState,
    context: Context,
    mainNavController: NavHostController,
) {
    var arananKelime by rememberSaveable { mutableStateOf(Constants.EMPTY_STRING) }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val toaster = rememberToasterState()

    fun clearSearchState() {
        viewModel.eventHandle(MainEvent.BulunanlarListesiniTemizle)
        viewModel.eventHandle(MainEvent.AramaAktifliginiDegistir(false))
    }

    LaunchedEffect(Unit) { // Ekran açıldığında odaklanma ve klavyeyi açma işlemi
        focusRequester.requestFocus()
    }

    BottomSnackbar(toaster)

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = arananKelime,
                onQueryChange = {
                    arananKelime = it
                    viewModel.eventHandle(MainEvent.NotlardaAra(arananKelime))
                },
                onSearch = {
                    focusManager.clearFocus() // Arama yapıldığında klavyeyi kapat
                },
                expanded = state.aramaAktifMi,
                onExpandedChange = {},
                placeholder = { Text(context.getString(R.string.notlarda_ara)) },
                enabled = true,
                modifier = Modifier.focusRequester(focusRequester)
            )
        },
        expanded = state.aramaAktifMi,
        onExpandedChange = { isActive ->
            viewModel.eventHandle(MainEvent.AramaAktifliginiDegistir(isActive))
            if (!isActive) {
                arananKelime = ""
                viewModel.eventHandle(MainEvent.BulunanlarListesiniTemizle)
            }
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 8.dp),
        ) {
            item {
                Text(text = state.bulunanlarListesi.size.toString() + context.getString(R.string.not_bulundu))
            }

            items(items = state.bulunanlarListesi) {
                NoteCard(
                    modifier = Modifier.padding(vertical = 4.dp),
                    note = it,
                    onEditClick = {
                        mainNavController.sayfayaGit(
                            Destination.DuzenleScreen(noteIdParam = it.id!!, duzenlemeAktifOlacakMiParam = true)
                        )
                        clearSearchState()
                    },
                    onSilClick = { note ->
                        toaster.show(
                            message = context.getString(R.string.arama_ekranindayken_notlar_silinemez),
                            duration = 3300.milliseconds,
                            type = ToastType.Warning,
                        )
                    },
                    onOpenClick = {
                        mainNavController.sayfayaGit(Destination.DuzenleScreen(noteIdParam = it.id!!))
                        clearSearchState()
                    }
                )
            }
        }
    }
}
