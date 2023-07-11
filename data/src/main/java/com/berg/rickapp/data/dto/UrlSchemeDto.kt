package com.berg.rickapp.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UrlSchemeDto(
    @SerialName("name") val name: String? = null,
    @SerialName("url") val url: String? = null,
)