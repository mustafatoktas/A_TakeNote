package com.mustafatoktas.nottut.di

import android.content.Context
import com.mustafatoktas.nottut.data.local.MyDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideMyDataStore(@ApplicationContext context: Context): MyDataStore {
        return MyDataStore(context)
    }
}
