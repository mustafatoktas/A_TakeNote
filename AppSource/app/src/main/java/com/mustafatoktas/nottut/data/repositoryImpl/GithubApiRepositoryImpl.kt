package com.mustafatoktas.nottut.data.repositoryImpl

import com.mustafatoktas.nottut.data.remote.GithubAPI
import com.mustafatoktas.nottut.domain.model.UpdateInfo
import com.mustafatoktas.nottut.domain.repository.GithubApiRepository
import javax.inject.Inject

class GithubApiRepositoryImpl @Inject constructor(
    private val api: GithubAPI
) : GithubApiRepository {

    override suspend fun checkForUpdates(): UpdateInfo {
        return api.checkForUpdates()
    }
}
