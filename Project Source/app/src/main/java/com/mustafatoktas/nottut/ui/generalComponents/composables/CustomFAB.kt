package com.mustafatoktas.nottut.ui.generalComponents.composables

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CustomFAB(
    onClick: () -> Unit = {},
    imageVector: ImageVector,
) {
    FloatingActionButton(
        onClick = onClick,
    ) {
        Icon(imageVector = imageVector, contentDescription = null)
    }
}
