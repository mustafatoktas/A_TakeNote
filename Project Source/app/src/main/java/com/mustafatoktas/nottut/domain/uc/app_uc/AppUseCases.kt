package com.mustafatoktas.nottut.domain.uc.app_uc

data class AppUseCases(
    val getVersionName: GetVersionName,
    val stringResourceSaglayici: StringResourceSaglayici,
    val getOperationSystemName: GetOperationSystemName,
    val getPhoneModelName: GetPhoneModelName,
)
