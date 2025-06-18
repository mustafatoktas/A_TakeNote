package com.mustafatoktas.nottut.ui.duzenle.components

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.mustafatoktas.nottut.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DuzenleToolbar(
    context: Context,
    geriTiklandi: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(text = context.getString(R.string.ekle_duzenle))
        },
        navigationIcon = {
            IconButton(
                onClick = geriTiklandi
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBackIos, contentDescription = null)
            }
        },
    )
}
