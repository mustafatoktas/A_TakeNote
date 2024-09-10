package com.mustafatoktas.nottut.ui.generalComponents.composables

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.ui.generalComponents.siralama_siniflari.NotSiralamasi
import com.mustafatoktas.nottut.ui.generalComponents.siralama_siniflari.SiralamaTipi

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    notSiralamasi: NotSiralamasi = NotSiralamasi.Tarih(SiralamaTipi.ZAsiralama),
    onOrderChange: (NotSiralamasi) -> Unit,
    context: Context,
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButtonWithText(
                text = context.getString(R.string.baslik),
                selected = notSiralamasi is NotSiralamasi.Baslik,
                onSelect = { onOrderChange(NotSiralamasi.Baslik(notSiralamasi.siralamaTipi)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            RadioButtonWithText(
                text = context.getString(R.string.tarih),
                selected = notSiralamasi is NotSiralamasi.Tarih,
                onSelect = { onOrderChange(NotSiralamasi.Tarih(notSiralamasi.siralamaTipi)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            RadioButtonWithText(
                text = context.getString(R.string.renk),
                selected = notSiralamasi is NotSiralamasi.Renk,
                onSelect = { onOrderChange(NotSiralamasi.Renk(notSiralamasi.siralamaTipi)) }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButtonWithText(
                text = context.getString(R.string.a_z),
                selected = notSiralamasi.siralamaTipi is SiralamaTipi.AZsiralama,
                onSelect = {
                    onOrderChange(notSiralamasi.copy(SiralamaTipi.AZsiralama))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            RadioButtonWithText(
                text = context.getString(R.string.z_a),
                selected = notSiralamasi.siralamaTipi is SiralamaTipi.ZAsiralama,
                onSelect = {
                    onOrderChange(notSiralamasi.copy(SiralamaTipi.ZAsiralama))
                }
            )
        }
    }
}
