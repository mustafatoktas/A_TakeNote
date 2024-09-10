package com.mustafatoktas.nottut.ui.ayarlar.components

import android.content.Context
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.mustafatoktas.nottut.R

@Composable
fun DialogParola(
    onConfirmTiklandi: () -> Unit,
    context: Context,
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = context.getString(R.string.parola_korumasi_cok_yakında))
        },
        text = {
            Text(
                text = context.getString(
                    R.string.bu_ozellik_ile_uygulamaniza_parola_ekleyerek_daha_guvenli_hale_getirebileceksiniz
                )
            )
        },
        confirmButton = {
            TextButton(
                onClick = onConfirmTiklandi
            ) {
                Text(text = context.getString(R.string.yeni_versiyonu_heyecanla_bekliyorum))
            }
        }
    )
}
