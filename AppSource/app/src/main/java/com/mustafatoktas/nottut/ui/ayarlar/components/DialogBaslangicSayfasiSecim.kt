package com.mustafatoktas.nottut.ui.ayarlar.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.common.BaslangicSayfasi

@Composable
fun DialogBaslangicSayfasiSecim(
    simdiki: BaslangicSayfasi,
    onDismissRequest: () -> Unit,
    onClickYeni: (BaslangicSayfasi) -> Unit
) {
    val context = LocalContext.current
    val secenekler = listOf(BaslangicSayfasi.Tum_Notlar, BaslangicSayfasi.Favoriler)

    StandartSettingsSecimDialog(
        title = context.getString(R.string.tema_sec),
        options = secenekler.map { it.getDisplayName(context) },
        mevcutSeciliOption = simdiki.getDisplayName(context),
        onDismissRequest = onDismissRequest,
        onClickYeniOption = { secilenSayfa ->
            val tema = secenekler.find { it.getDisplayName(context) == secilenSayfa }
            tema?.let {
                onClickYeni(it)
            }
        }
    )
}
