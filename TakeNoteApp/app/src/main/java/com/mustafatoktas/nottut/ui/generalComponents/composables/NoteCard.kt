package com.mustafatoktas.nottut.ui.generalComponents.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdded
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.ui.theme.poppinsFontFamily

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    note: Note,
    onOpenClick: (Note) -> Unit,
    onEditClick: (Note) -> Unit,
    onSilClick: (Note) -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onOpenClick.invoke(note)
            },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(note.renk))
                .padding(12.dp),
        ) {
            if (!note.isFavori) {
                Spacer(modifier = Modifier.size(8.dp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(note.renk)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .background(Color(note.renk))
                        .weight(8.5f),
                    text = note.baslik,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black,
                )
                if (note.isFavori) {
                    Icon(
                        imageVector = Icons.Filled.BookmarkAdded,
                        tint = Color.Black,
                        contentDescription = null,
                        modifier = Modifier.weight(1.5f)
                    )
                }
            }
            Text(
                text = note.icerik,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
            )
            HorizontalDivider(
                modifier = Modifier.padding(top = 8.dp),
                color = Color.Black,
                thickness = 0.5.dp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {
                        onSilClick.invoke(note)
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Outlined.DeleteOutline,
                        tint = Color.Black,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = {
                        onEditClick.invoke(note)
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Default.EditNote,
                        tint = Color.Black,
                        contentDescription = null
                    )
                }
            }
        }
    }
}
