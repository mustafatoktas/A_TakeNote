package com.mustafatoktas.nottut.di

import android.content.Context
import androidx.room.Room
import com.mustafatoktas.nottut.data.local.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            NoteDatabase.ROOM_VERITABANI_ADI,
        ).fallbackToDestructiveMigration()
            .build()
    }
}
