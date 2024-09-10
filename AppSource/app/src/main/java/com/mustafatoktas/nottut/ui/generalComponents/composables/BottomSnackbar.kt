package com.mustafatoktas.nottut.ui.generalComponents.composables

import androidx.compose.runtime.Composable
import com.dokar.sonner.Toaster
import com.dokar.sonner.ToasterState

@Composable
fun BottomSnackbar(toasterState: ToasterState) {
    Toaster(state = toasterState)
}
