package com.mustafatoktas.nottut.ui.ayarlar.components

import android.content.Context
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.common.Constants

@Composable
fun DialogGuncellemeDenetle(
    guncellemeMesaji: String?,
    guncellemeAdresi: String?,
    isLoading: Boolean,
    hataVarMi: Boolean,
    onDismissRequest: () -> Unit,
    onSimdiIndirClick: () -> Unit,
    context: Context,
) {
    when {
        isLoading -> LoadingDialog()
        hataVarMi -> ErrorDialog(guncellemeMesaji, onDismissRequest, context)
        guncellemeAdresi != null -> GuncellemeVarDialog(
            guncellemeMesaji = guncellemeMesaji,
            onDismissRequest = onDismissRequest,
            onSimdiIndirClick = onSimdiIndirClick,
            context = context
        )
        else -> UpToDateDialog(onDismissRequest, context)
    }
}

@Composable
fun LoadingDialog() {
    Dialog(
        onDismissRequest = {}
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorDialog(
    guncellemeMesaji: String?,
    onDismissRequest: () -> Unit,
    context: Context,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(
                text = context.getString(R.string.hata),
                color = MaterialTheme.colorScheme.error
            )
        },
        text = {
            Text(text = guncellemeMesaji ?: context.getString(R.string.bilinmeyen_bir_hata_olustu))
        },
        confirmButton = { DialogButton(context.getString(R.string.tamam), onClick = onDismissRequest) }
    )
}

@Composable
fun GuncellemeVarDialog(
    guncellemeMesaji: String?,
    onDismissRequest: () -> Unit,
    onSimdiIndirClick: () -> Unit,
    context: Context,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(text = context.getString(R.string.guncelleme_bulundu)) },
        text = { Text(text = guncellemeMesaji ?: Constants.EMPTY_STRING) },
        confirmButton = {
            Button(
                onClick = onSimdiIndirClick
            ) {
                Text(context.getString(R.string.indir))
            }
        },
        dismissButton = { DialogButton(text = context.getString(R.string.sonra), onClick = onDismissRequest) }
    )
}

@Composable
fun UpToDateDialog(
    onDismissRequest: () -> Unit,
    context: Context,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(text = context.getString(R.string.harika)) },
        text = { Text(text = context.getString(R.string.uygulamaniz_guncel)) },
        confirmButton = { DialogButton(context.getString(R.string.tamam), onClick = onDismissRequest) }
    )
}

@Composable
fun DialogButton(text: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick
    ) {
        Text(text)
    }
}
