package com.mustafatoktas.nottut.ui.ayarlar.components

import android.content.Context
import android.os.Build
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.mustafatoktas.nottut.R

@Composable
fun DialogDinamikRenkSecim(
    onDismissRequest: () -> Unit,
    onClickYeni: () -> Unit,
    context: Context,
) {
    when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        true -> onClickYeni.invoke()
        false -> {
            AlertDialog(
                onDismissRequest = onDismissRequest,
                title = {
                    Text(text = context.getString(R.string.yetersiz_android_surumu_baslik))
                },
                text = {
                    Text(text = context.getString(R.string.yetersiz_android_surumu_icerik))
                },
                confirmButton = {
                    TextButton(
                        onClick = onDismissRequest
                    ) {
                        Text(text = context.getString(R.string.tamam))
                    }
                },
            )
        }
    }
}
