package com.mustafatoktas.nottut.ui.generalComponents.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.dokar.sonner.Toaster
import com.dokar.sonner.ToasterState

@Composable
fun TopSnackbar(toasterState: ToasterState) {
    Toaster(state = toasterState, alignment = Alignment.TopCenter)
}
