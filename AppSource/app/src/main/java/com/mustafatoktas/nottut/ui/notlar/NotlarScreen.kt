package com.mustafatoktas.nottut.ui.notlar

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.dokar.sonner.TextToastAction
import com.dokar.sonner.ToastType
import com.dokar.sonner.rememberToasterState
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.ui.generalComponents.NotlarBaseEvent
import com.mustafatoktas.nottut.ui.generalComponents.composables.EmptyContent
import com.mustafatoktas.nottut.ui.generalComponents.composables.NotlarContent
import com.mustafatoktas.nottut.ui.generalComponents.composables.TopSnackbar
import com.mustafatoktas.nottut.ui.notlar.viewmodel.NotlarEventUi
import com.mustafatoktas.nottut.ui.notlar.viewmodel.NotlarViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun NotlarScreen(
    modifier: Modifier = Modifier,
    mainNavController: NavHostController,
    context: Context,
    viewModel: NotlarViewModel,
) {
    val state = viewModel.state.value
    val toaster = rememberToasterState()

    TopSnackbar(toaster)

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is NotlarEventUi.SnackBarGoster -> {
                    toaster.show(
                        message = context.getString(R.string.not_silindi),
                        duration = 3300.milliseconds,
                        type = ToastType.Warning,
                        action = TextToastAction(
                            text = context.getString(R.string.geri_al),
                            onClick = {
                                viewModel.eventHandle(NotlarBaseEvent.GeriKaydetNot)
                                toaster.dismiss(it)
                            },
                        )
                    )
                }
            }
        }
    }

    Surface(modifier = modifier.fillMaxSize()) {
        when (state.notlar.isEmpty()) {
            true -> EmptyContent(context.getString(R.string.not_bulunamadi))
            false ->
                NotlarContent(
                    context = context,
                    state = state,
                    mainNavController = mainNavController,
                    viewModel = viewModel,
                    onSilClick = { note ->
                        viewModel.eventHandle(NotlarBaseEvent.SilNote(note))
                    }
                )
        }
    }
}
