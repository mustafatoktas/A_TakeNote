package com.mustafatoktas.nottut.di

import android.content.Context
import com.mustafatoktas.nottut.domain.uc.app_uc.AppUseCases
import com.mustafatoktas.nottut.domain.uc.app_uc.GetOperationSystemName
import com.mustafatoktas.nottut.domain.uc.app_uc.GetPhoneModelName
import com.mustafatoktas.nottut.domain.uc.app_uc.GetVersionName
import com.mustafatoktas.nottut.domain.uc.app_uc.StringResourceSaglayici
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppUseCaseModule {

    @Provides
    @Singleton
    fun provideAppUseCases(@ApplicationContext context: Context): AppUseCases {
        return AppUseCases(
            getVersionName = GetVersionName(context),
            stringResourceSaglayici = StringResourceSaglayici(context),
            getOperationSystemName = GetOperationSystemName(),
            getPhoneModelName = GetPhoneModelName()
        )
    }
}
