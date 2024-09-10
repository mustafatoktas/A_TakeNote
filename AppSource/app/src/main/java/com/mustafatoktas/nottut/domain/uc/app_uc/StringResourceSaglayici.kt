package com.mustafatoktas.nottut.domain.uc.app_uc

import android.content.Context

class StringResourceSaglayici(
    private val context: Context
) {
    operator fun invoke(id: Int): String {
        return context.getString(id)
    }
}
