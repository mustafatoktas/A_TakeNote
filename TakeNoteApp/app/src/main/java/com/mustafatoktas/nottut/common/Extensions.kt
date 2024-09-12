package com.mustafatoktas.nottut.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.mustafatoktas.nottut.ui.navigation.Destination

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

fun NavHostController.sayfayaGit(destination: Destination) {
    this.navigate(destination) {
        popUpTo(this@sayfayaGit.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
