package com.mustafatoktas.nottut.data.remote

import com.mustafatoktas.nottut.common.Constants
import com.mustafatoktas.nottut.domain.model.UpdateInfo
import retrofit2.http.GET

interface GithubAPI {

    @GET(Constants.VERSION_CHECK_LINK)
    suspend fun checkForUpdates(): UpdateInfo
}
