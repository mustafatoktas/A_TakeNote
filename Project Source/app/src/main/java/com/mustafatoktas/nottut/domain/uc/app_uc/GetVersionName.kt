package com.mustafatoktas.nottut.domain.uc.app_uc

import android.content.Context

class GetVersionName(
    private val context: Context,
) {

    operator fun invoke(): String {
        val pm = context.packageManager
        val packageInfo = pm.getPackageInfo(context.packageName, 0)
        return "v" + packageInfo.versionName
    }
}
