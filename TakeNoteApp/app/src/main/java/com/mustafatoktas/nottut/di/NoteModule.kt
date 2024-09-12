package com.mustafatoktas.nottut.di

import com.mustafatoktas.nottut.data.local.NoteDatabase
import com.mustafatoktas.nottut.data.repositoryImpl.NoteRepositoryImpl
import com.mustafatoktas.nottut.domain.repository.NoteRepository
import com.mustafatoktas.nottut.domain.uc.app_uc.AppUseCases
import com.mustafatoktas.nottut.domain.uc.note_uc.EkleNot
import com.mustafatoktas.nottut.domain.uc.note_uc.GetArananNotlar
import com.mustafatoktas.nottut.domain.uc.note_uc.GetNot
import com.mustafatoktas.nottut.domain.uc.note_uc.GetNotlar
import com.mustafatoktas.nottut.domain.uc.note_uc.NotUseCases
import com.mustafatoktas.nottut.domain.uc.note_uc.SilNot
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(dao = db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository, appUseCases: AppUseCases): NotUseCases {
        return NotUseCases(
            getNotlar = GetNotlar(repository),
            silNot = SilNot(repository),
            ekleNot = EkleNot(repository, appUseCases),
            getNot = GetNot(repository),
            getArananNotlar = GetArananNotlar(repository),
        )
    }
}
