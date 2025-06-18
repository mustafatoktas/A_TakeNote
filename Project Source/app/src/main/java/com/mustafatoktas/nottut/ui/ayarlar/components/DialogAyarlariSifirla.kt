package com.mustafatoktas.nottut.ui.ayarlar.components

import android.content.Context
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.mustafatoktas.nottut.R

@Composable
fun DialogAyarlariSifirla(
    dismissTiklandi: () -> Unit,
    sifirlaTiklandi: () -> Unit,
    context: Context,
) {
    AlertDialog(
        onDismissRequest = dismissTiklandi,
        dismissButton = {
            TextButton(
                onClick = dismissTiklandi
            ) {
                Text(text = context.getString(R.string.vazgec))
            }
        },
        confirmButton = {
            TextButton(
                onClick = sifirlaTiklandi
            ) {
                Text(text = context.getString(R.string.onayla))
            }
        },
        title = {
            Text(text = context.getString(R.string.reset_all_settings_baslik))
        },
        text = {
            Text(text = context.getString(R.string.reset_all_settings_icerik))
        }
    )
}
