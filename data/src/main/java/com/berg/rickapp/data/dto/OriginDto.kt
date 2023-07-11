package com.berg.rickapp.data.dto

import com.google.gson.annotations.SerializedName

data class OriginDto(
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null,
)

data class LocationDto(
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null,
)