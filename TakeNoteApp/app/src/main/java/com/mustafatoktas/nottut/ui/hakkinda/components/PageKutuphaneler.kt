package com.mustafatoktas.nottut.ui.hakkinda.components

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mustafatoktas.nottut.common.ConstantsLibrary
import com.mustafatoktas.nottut.common.tarayicidaAc

@Composable
fun PageKutuphaneler(
    context: Context
) {
    val libraries = listOf(
        Triple(ConstantsLibrary.RETROFIT, ConstantsLibrary.RETROFIT_LICENSE, ConstantsLibrary.RETROFIT_URL),
        Triple(ConstantsLibrary.SONNER, ConstantsLibrary.SONNER_LICENSE, ConstantsLibrary.SONNER_URL),
        Triple(ConstantsLibrary.COIL, ConstantsLibrary.COIL_LICENSE, ConstantsLibrary.COIL_URL),
        Triple(ConstantsLibrary.KETCH, ConstantsLibrary.KETCH_LICENSE, ConstantsLibrary.KETCH_URL),
        Triple(ConstantsLibrary.DETEKT, ConstantsLibrary.DETEKT_LICENSE, ConstantsLibrary.DETEKT_URL)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 6.dp)
            .padding(top = 4.dp)
    ) {
        items(libraries) { library ->
            LibraryRow(
                baslik = library.first,
                icerik = library.second,
            ) {
                context.tarayicidaAc(library.third)
            }
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
