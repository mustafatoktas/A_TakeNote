package com.mustafatoktas.nottut.ui.duzenle

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.dokar.sonner.ToastType
import com.dokar.sonner.ToasterDefaults
import com.dokar.sonner.rememberToasterState
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.ui.duzenle.components.ColorSecimSection
import com.mustafatoktas.nottut.ui.duzenle.components.DuzenleToolbar
import com.mustafatoktas.nottut.ui.duzenle.viewmodel.DuzenleEvent
import com.mustafatoktas.nottut.ui.duzenle.viewmodel.DuzenleEventUi
import com.mustafatoktas.nottut.ui.duzenle.viewmodel.DuzenleViewModel
import com.mustafatoktas.nottut.ui.generalComponents.composables.CustomFAB
import com.mustafatoktas.nottut.ui.generalComponents.composables.TopSnackbar
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DuzenleScreen(
    mainNavController: NavHostController,
    context: Context,
    viewModel: DuzenleViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val toaster = rememberToasterState()
    val focusManager = LocalFocusManager.current

    TopSnackbar(toaster)

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                DuzenleEventUi.NotKaydedildi -> {
                    mainNavController.navigateUp()
                }
                is DuzenleEventUi.SnackBarGoster -> {
                    toaster.show(
                        message = event.mesaj,
                        duration = ToasterDefaults.DurationShort,
                        type = ToastType.Error,
                    )
                }
            }
        }
    }

    Scaffold(
        topBar = {
            DuzenleToolbar(
                context = context,
                geriTiklandi = {
                    mainNavController.navigateUp()
                },
            )
        },
        floatingActionButton = {
            CustomFAB(
                imageVector = if (state.duzenlemeEtkinMi) Icons.Default.Save else Icons.Default.EditNote,
                onClick = {
                    if (state.duzenlemeEtkinMi) {
                        viewModel.eventHandle(DuzenleEvent.NotKaydet)
                    } else {
                        viewModel.eventHandle(DuzenleEvent.NotDuzenlemeDurumuDegistir)
                    }
                },
            )
        },
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            ColorSecimSection(
                state = state,
                onClick = { colorInt ->
                    if (state.duzenlemeEtkinMi) {
                        viewModel.eventHandle(DuzenleEvent.RenkDegisimi(colorInt))
                    } else {
                        toaster.show(
                            message = context.getString(R.string.duzenleme_etkinlestir_uyarisi),
                            duration = ToasterDefaults.DurationShort,
                            type = ToastType.Warning,
                        )
                    }
                },
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    value = state.baslik,
                    onValueChange = {
                        viewModel.eventHandle(DuzenleEvent.YazilanBaslik(it))
                    },
                    label = {
                        Text(text = context.getString(R.string.baslik))
                    },
                    singleLine = true,
                    readOnly = !state.duzenlemeEtkinMi,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        capitalization = KeyboardCapitalization.Sentences,
                        imeAction = ImeAction.Next,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    )
                )
                IconButton(
                    onClick = {
                        if (state.duzenlemeEtkinMi) {
                            viewModel.eventHandle(DuzenleEvent.FavoriTiklandi)
                        } else {
                            toaster.show(
                                message = context.getString(R.string.duzenleme_etkinlestir_uyarisi),
                                duration = ToasterDefaults.DurationShort,
                                type = ToastType.Warning,
                            )
                        }
                    }
                ) {
                    Icon(
                        imageVector = if (state.favoriMi) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                readOnly = !state.duzenlemeEtkinMi,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 90.dp),
                value = state.icerik,
                onValueChange = {
                    viewModel.eventHandle(DuzenleEvent.YazilanIcerik(it))
                },
                label = {
                    Text(text = context.getString(R.string.icerik))
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Sentences,
                ),
            )
        }
    }
}
