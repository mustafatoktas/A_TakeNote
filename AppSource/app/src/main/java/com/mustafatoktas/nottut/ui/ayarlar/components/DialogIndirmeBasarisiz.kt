package com.mustafatoktas.nottut.ui.ayarlar.components

import android.content.Context
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.mustafatoktas.nottut.R

@Composable
fun DialogIndirmeBasarisiz(
    context: Context,
    onDissmissTiklandi: () -> Unit,
    onConfirmTiklandi: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = context.getString(R.string.indirme_basarisiz))
        },
        text = {
            Text(text = context.getString(R.string.yeni_versiyonu_indirmekte_problem_yasiyorsaniz))
        },
        dismissButton = {
            TextButton(
                onClick = onDissmissTiklandi
            ) {
                Text(text = context.getString(R.string.sonra))
            }
        },
        confirmButton = {
            Button(
                onClick = onConfirmTiklandi
            ) {
                Text(text = context.getString(R.string.tamam))
            }
        }
    )
}
