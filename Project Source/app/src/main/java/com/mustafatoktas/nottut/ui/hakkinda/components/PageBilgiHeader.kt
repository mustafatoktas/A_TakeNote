package com.mustafatoktas.nottut.ui.hakkinda.components

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.common.Constants
import com.mustafatoktas.nottut.common.tarayicidaAc

@Composable
fun PageBilgiHeader(
    context: Context,
    versionNumber: String,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable {
                context.tarayicidaAc(Constants.GITHUB_LINK)
            }
            .padding(bottom = 20.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = R.drawable.app_logo,
            contentDescription = null,
            modifier = Modifier.size(70.dp)
        )
        Column(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Text(
                text = context.getString(R.string.app_name),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(text = context.getString(R.string.versiyon) + Constants.SPACE_STRING + versionNumber)
            Text(
                text = Constants.HERO_NAME,
                modifier = Modifier.clickable {
                    context.tarayicidaAc(Constants.HERO_GITHUB_PROFILE)
                }
            )
        }
    }
}
