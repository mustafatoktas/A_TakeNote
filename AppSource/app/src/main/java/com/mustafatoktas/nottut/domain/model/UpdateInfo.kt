package com.mustafatoktas.nottut.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateInfo(
    @SerializedName("tag_name")
    val sonVersiyon: String?,

    @SerializedName("html_url")
    val releasesSayfasi: String?,

    @SerializedName("assets")
    val assetList: List<Asset>?
)

@Serializable
data class Asset(
    @SerializedName("name")
    val assetName: String?,

    @SerializedName("browser_download_url")
    val indirmeAdresi: String?
)
