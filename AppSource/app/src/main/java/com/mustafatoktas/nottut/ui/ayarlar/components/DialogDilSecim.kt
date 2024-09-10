package com.mustafatoktas.nottut.ui.ayarlar.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.common.Dil

@Composable
fun DialogDilSecim(
    simdiki: Dil,
    onDismissRequest: () -> Unit,
    onClickYeni: (Dil) -> Unit
) {
    val context = LocalContext.current
    val secenekler = listOf(Dil.Turkce, Dil.English)

    StandartSettingsSecimDialog(
        title = context.getString(R.string.dil_sec),
        options = secenekler.map { it.getDisplayName(context) },
        mevcutSeciliOption = simdiki.getDisplayName(context),
        onDismissRequest = onDismissRequest,
        onClickYeniOption = { secilenDil ->
            val dil = secenekler.find { it.getDisplayName(context) == secilenDil }
            dil?.let {
                onClickYeni(it)
            }
        }
    )
}
