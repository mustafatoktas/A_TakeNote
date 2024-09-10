package com.mustafatoktas.nottut.ui.ayarlar.components

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.SettingsBackupRestore
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.mustafatoktas.nottut.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AyarlarToolbar(
    navigationOnClick: () -> Unit = {},
    ayarlariSifirlaOnClick: () -> Unit = {},
    context: Context,
) {
    TopAppBar(
        title = {
            Text(text = context.getString(R.string.ayarlar))
        },
        navigationIcon = {
            IconButton(
                onClick = navigationOnClick

            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBackIos, contentDescription = null)
            }
        },
        actions = {
            IconButton(
                onClick = ayarlariSifirlaOnClick,
            ) {
                Icon(imageVector = Icons.Default.SettingsBackupRestore, contentDescription = null)
            }
        },
    )
}
