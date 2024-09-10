package com.mustafatoktas.nottut.ui.hakkinda.components

import android.content.Context
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.mustafatoktas.nottut.R

@Composable
fun DialogLibrariesInfo(
    onDismiss: () -> Unit,
    context: Context,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = context.getString(R.string.kullanılan_kutuphaneler_baslik))
        },
        text = {
            Text(text = context.getString(R.string.kullanılan_kutuphaneler_icerik))
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(text = context.getString(R.string.tamam))
            }
        },
    )
}
