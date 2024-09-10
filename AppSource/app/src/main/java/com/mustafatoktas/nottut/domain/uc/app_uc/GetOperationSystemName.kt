package com.mustafatoktas.nottut.domain.uc.app_uc

import android.os.Build

class GetOperationSystemName {

    operator fun invoke(): String {
        val versionName = Build.VERSION.RELEASE
        val sdkVersion = Build.VERSION.SDK_INT
        return "Android $versionName (API $sdkVersion)"
    }
}
