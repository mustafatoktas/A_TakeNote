package com.mustafatoktas.nottut.ui.main.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.mustafatoktas.nottut.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainToolbar(
    title: String,
    onClickSettings: () -> Unit = {},
    onClickInfo: () -> Unit = {},
    onClickSiralama: () -> Unit = {},
) {
    val context = LocalContext.current
    var dropDownGoster by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(text = title)
        },
        actions = {
            IconButton(
                onClick = onClickSiralama,
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.Sort, contentDescription = null)
            }

            IconButton(
                onClick = {
                    dropDownGoster = true
                },
            ) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }

            DropdownMenu(
                expanded = dropDownGoster,
                onDismissRequest = { dropDownGoster = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text(text = context.getString(R.string.ayarlar))
                    },
                    onClick = {
                        dropDownGoster = false
                        onClickSettings.invoke()
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Outlined.Settings, contentDescription = null)
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = context.getString(R.string.not_tut_hakkında)) },
                    onClick = {
                        onClickInfo.invoke()
                        dropDownGoster = false
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Outlined.Info, contentDescription = null)
                    }
                )
            }
        },
    )
}
