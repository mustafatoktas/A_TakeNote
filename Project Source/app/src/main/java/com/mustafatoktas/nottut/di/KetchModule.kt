package com.mustafatoktas.nottut.di

import android.content.Context
import com.ketch.DownloadConfig
import com.ketch.Ketch
import com.ketch.NotificationConfig
import com.mustafatoktas.nottut.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KetchModule {

    @Provides
    @Singleton
    fun provideKetch(@ApplicationContext context: Context): Ketch {
        return Ketch.builder()
            .setNotificationConfig(
                NotificationConfig(
                    enabled = true,
                    smallIcon = R.drawable.ic_stat_notification_logo,
                    showTime = false,
                )
            )
            .setDownloadConfig(
                DownloadConfig(
                    connectTimeOutInMs = 15_000,
                    readTimeOutInMs = 15_000,
                )
            )
            .build(context)
    }
}
