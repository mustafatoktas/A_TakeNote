package com.mustafatoktas.nottut.domain.uc.github_api_uc

import com.mustafatoktas.nottut.common.Constants
import com.mustafatoktas.nottut.common.Resource
import com.mustafatoktas.nottut.domain.model.IndirilecekNesne
import com.mustafatoktas.nottut.domain.repository.GithubApiRepository
import com.mustafatoktas.nottut.domain.uc.app_uc.AppUseCases
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class CheckForUpdates(
    private val api: GithubApiRepository,
    private val appUseCases: AppUseCases,
) {
    suspend operator fun invoke(): Flow<Resource<IndirilecekNesne>> {
        return flow {
            try {
                emit(Resource.Loading())

                val response = api.checkForUpdates()

                val sonVersiyon = response.sonVersiyon ?: Constants.EMPTY_STRING

                val asset = response.assetList?.find {
                    it.assetName?.endsWith(Constants.APK_UZANTISI) == true
                } // assetList içindeki ilk APK dosyasını bul
                val indirmeAdresi = asset?.indirmeAdresi ?: Constants.EMPTY_STRING

                val mevcutVersiyon = appUseCases.getVersionName.invoke()

                if (sonVersiyon.isNotEmpty() && sonVersiyon > mevcutVersiyon) {
                    emit(
                        Resource.Success(
                            IndirilecekNesne(
                                sonVersiyon = sonVersiyon,
                                indirmeAdresi = indirmeAdresi,
                                dosyaAdi = asset?.assetName,
                                releasesSayfasi = response.releasesSayfasi
                            )
                        )
                    )
                } else {
                    emit(
                        Resource.Success(
                            IndirilecekNesne(
                                sonVersiyon = mevcutVersiyon,
                                indirmeAdresi = null,
                                dosyaAdi = null,
                                releasesSayfasi = null
                            )
                        )
                    )
                }
            } catch (e: HttpException) {
                emit(Resource.Error("${e.message}"))
            } catch (e: Exception) {
                emit(Resource.Error("${e.message}"))
            } finally {
                emit(Resource.Loading(false))
            }
        }
    }
}
