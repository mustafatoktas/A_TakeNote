package com.mustafatoktas.nottut.ui.duzenle.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.ui.duzenle.viewmodel.DuzenleState

@Composable
fun ColorSecimSection(
    state: DuzenleState,
    onClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Note.notRenkleri.forEach { color ->
            val colorInt = color.toArgb()
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .shadow(15.dp, CircleShape)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp,
                        color = if (state.notRengi == colorInt) {
                            MaterialTheme.colorScheme.onBackground
                        } else {
                            Color.Transparent
                        },
                        shape = CircleShape
                    )
                    .background(color)
                    .clickable {
                        onClick.invoke(colorInt)
                    }
            )
        }
    }
}
