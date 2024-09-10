package com.mustafatoktas.nottut.di

import com.mustafatoktas.nottut.common.Constants.BASE_URL
import com.mustafatoktas.nottut.data.remote.GithubAPI
import com.mustafatoktas.nottut.data.repositoryImpl.GithubApiRepositoryImpl
import com.mustafatoktas.nottut.domain.repository.GithubApiRepository
import com.mustafatoktas.nottut.domain.uc.app_uc.AppUseCases
import com.mustafatoktas.nottut.domain.uc.github_api_uc.CheckForUpdates
import com.mustafatoktas.nottut.domain.uc.github_api_uc.GithubApiUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GithubApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(): GithubAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideGithubApiRepository(api: GithubAPI): GithubApiRepository {
        return GithubApiRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGithubApiUseCases(repository: GithubApiRepository, appUseCases: AppUseCases): GithubApiUseCases {
        return GithubApiUseCases(
            checkForUpdates = CheckForUpdates(repository, appUseCases)
        )
    }
}
