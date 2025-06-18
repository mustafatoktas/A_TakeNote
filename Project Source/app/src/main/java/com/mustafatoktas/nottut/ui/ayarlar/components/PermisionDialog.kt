package com.mustafatoktas.nottut.ui.ayarlar.components

import android.content.Context
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.mustafatoktas.nottut.R

@Composable
fun PermissionDialog(
    context: Context,
    isPermanentlyDeclined: Boolean,
    onDismissRequest: () -> Unit,
    onIzinVerClick: () -> Unit,
    onAyarlaraGitClick: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = context.getString(R.string.izin_gerekli))
        },
        text = {
            Text(
                text = if (isPermanentlyDeclined) {
                    context.getString(
                        R.string.bildirim_izni_kalici_olarak_reddedildi
                    )
                } else {
                    context.getString(R.string.bildirim_izni_reddedildi)
                }
            )
        },
        dismissButton = {
            TextButton(
                onClick = onDismissRequest
            ) {
                Text(text = context.getString(R.string.vazgec))
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    when (isPermanentlyDeclined) {
                        true -> onAyarlaraGitClick.invoke()
                        false -> onIzinVerClick.invoke()
                    }
                    onDismissRequest.invoke()
                },
            ) {
                Text(
                    text = if (isPermanentlyDeclined) {
                        context.getString(
                            R.string.ayarlara_git
                        )
                    } else {
                        context.getString(R.string.izin_ver)
                    }
                )
            }
        },
    )
}
