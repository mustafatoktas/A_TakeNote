package com.mustafatoktas.nottut.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mustafatoktas.nottut.ui.theme.BabyBlue
import com.mustafatoktas.nottut.ui.theme.LightGreen
import com.mustafatoktas.nottut.ui.theme.RedOrange
import com.mustafatoktas.nottut.ui.theme.RedPink
import com.mustafatoktas.nottut.ui.theme.Violet

@Entity
data class Note(

    @PrimaryKey(autoGenerate = true) val id: Int?,
    val baslik: String,
    val icerik: String,
    val isFavori: Boolean,
    val zamanDamgasi: Long,
    val renk: Int,
) {
    companion object {
        val notRenkleri = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class GecersizNotHatasi(mesaj: String) : Exception(mesaj)
