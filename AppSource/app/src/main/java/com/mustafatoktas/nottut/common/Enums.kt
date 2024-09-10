package com.mustafatoktas.nottut.common

import android.content.Context
import com.mustafatoktas.nottut.R

enum class CihazDurumu {
    Rootlu,
    Emulator,
    Normal
}

enum class Tema {
    Acik,
    Koyu,
    Sistem;

    fun getDisplayName(context: Context): String {
        return when (this) {
            Acik -> context.getString(R.string.tema_acik)
            Koyu -> context.getString(R.string.tema_koyu)
            Sistem -> context.getString(R.string.tema_sistem)
        }
    }
}

enum class BaslangicSayfasi {
    Tum_Notlar,
    Favoriler;

    fun getDisplayName(context: Context): String {
        return when (this) {
            Tum_Notlar -> context.getString(R.string.tum_notlar)
            Favoriler -> context.getString(R.string.favoriler)
        }
    }
}

enum class OnOFF {
    Acik,
    Kapali;

    fun getDisplayName(context: Context): String {
        return when (this) {
            Acik -> context.getString(R.string.acik)
            Kapali -> context.getString(R.string.kapali)
        }
    }
}

enum class Dil {
    English,
    Turkce;

    fun getDisplayName(context: Context): String {
        return when (this) {
            English -> context.getString(R.string.ingilizce)
            Turkce -> context.getString(R.string.turkce)
        }
    }
}
