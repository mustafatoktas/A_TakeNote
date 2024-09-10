package com.mustafatoktas.nottut.domain.uc.app_uc

import android.os.Build

class GetPhoneModelName {

    operator fun invoke(): String {
        return Build.MODEL
    }
}
