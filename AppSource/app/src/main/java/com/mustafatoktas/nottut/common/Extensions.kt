package com.mustafatoktas.nottut.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings

fun Activity.uygulamaAyarlariniAc() {
    Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts(Constants.PACKAGE, packageName, null)
    ).also(::startActivity)
}

fun Context.tarayicidaAc(url: String?) {
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url ?: Constants.EMPTY_STRING))
    startActivity(browserIntent)
}
