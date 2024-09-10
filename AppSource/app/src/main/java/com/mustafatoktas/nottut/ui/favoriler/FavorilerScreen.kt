package com.mustafatoktas.nottut.ui.favoriler

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.dokar.sonner.TextToastAction
import com.dokar.sonner.ToastType
import com.dokar.sonner.rememberToasterState
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.ui.favoriler.viewmodel.FavorilerEventUi
import com.mustafatoktas.nottut.ui.favoriler.viewmodel.FavorilerViewModel
import com.mustafatoktas.nottut.ui.generalComponents.NotlarBaseEvent
import com.mustafatoktas.nottut.ui.generalComponents.composables.EmptyContent
import com.mustafatoktas.nottut.ui.generalComponents.composables.NotlarContent
import com.mustafatoktas.nottut.ui.generalComponents.composables.TopSnackbar
import kotlinx.coroutines.flow.collectLatest
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun FavorilerScreen(
    modifier: Modifier = Modifier,
    mainNavController: NavHostController,
    context: Context,
    viewModel: FavorilerViewModel,
) {
    val state = viewModel.state.value
    val toaster = rememberToasterState()

    TopSnackbar(toaster)

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is FavorilerEventUi.SnackBarGoster -> {
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

    Box(modifier = modifier.fillMaxSize()) {
        when {
            state.notlar.isEmpty() -> EmptyContent(context.getString(R.string.favori_not_bulunamadi))
            else ->
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
