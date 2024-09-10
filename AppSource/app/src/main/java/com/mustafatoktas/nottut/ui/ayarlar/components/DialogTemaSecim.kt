package com.mustafatoktas.nottut.ui.ayarlar.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.common.Tema

@Composable
fun DialogTemaSecim(
    simdiki: Tema,
    onDismissRequest: () -> Unit,
    onClickYeni: (Tema) -> Unit,
) {
    val context = LocalContext.current
    val secenekler = listOf(Tema.Acik, Tema.Koyu, Tema.Sistem)

    StandartSettingsSecimDialog(
        title = context.getString(R.string.tema_sec),
        options = secenekler.map { it.getDisplayName(context) },
        mevcutSeciliOption = simdiki.getDisplayName(context),
        onDismissRequest = onDismissRequest,
        onClickYeniOption = { secilenTema ->
            val tema = secenekler.find { it.getDisplayName(context) == secilenTema }
            tema?.let {
                onClickYeni(it)
            }
        }
    )
}
