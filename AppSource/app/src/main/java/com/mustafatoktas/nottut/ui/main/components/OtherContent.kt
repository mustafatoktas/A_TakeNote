package com.mustafatoktas.nottut.ui.main.components

import android.app.Activity
import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.mustafatoktas.nottut.R

@Composable
fun OtherContent(
    baslik: String,
    icerik: String,
    @DrawableRes resim: Int? = null,
    context: Context,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp).padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = baslik,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 24.dp)
        )
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(resim ?: R.drawable.emulator)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier.width(300.dp).padding(bottom = 24.dp),
            imageLoader = ImageLoader.Builder(context)
                .components {
                    add(GifDecoder.Factory())
                }
                .build()
        )
        Text(
            text = icerik,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Button(
            onClick = {
                (context as Activity).finish()
                // context.imageLoader.diskCache?.clear()  // önbelleği temizlemek için
                // context.imageLoader.memoryCache?.clear()
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text(text = context.getString(R.string.uygulamayi_kapat))
        }
    }
}
