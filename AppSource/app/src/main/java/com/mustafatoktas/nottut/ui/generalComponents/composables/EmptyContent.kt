package com.mustafatoktas.nottut.ui.generalComponents.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mustafatoktas.nottut.R

@Composable
fun EmptyContent(
    text: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = R.drawable.empty,
            contentDescription = null,
            modifier = Modifier
                .size(width = 253.dp, height = 166.dp),
        )
        Text(
            text = text,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}
