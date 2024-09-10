package com.mustafatoktas.nottut.domain.repository

import com.mustafatoktas.nottut.domain.model.UpdateInfo

interface GithubApiRepository {
    suspend fun checkForUpdates(): UpdateInfo
}
