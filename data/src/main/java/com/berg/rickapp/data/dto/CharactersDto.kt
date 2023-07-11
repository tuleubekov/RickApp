package com.berg.rickapp.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterListDto(
    @SerialName("info") val info: CharacterListInfoDto? = null,
    @SerialName("results") val results: List<CharacterDto>? = null,
)

@Serializable
data class CharacterListInfoDto(
    @SerialName("count") val count: Int? = null,
    @SerialName("pages") val pages: Int? = null,
    @SerialName("next") val next: String? = null,
    @SerialName("prev") val prev: String? = null,
)

@Serializable
data class CharacterDto(
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("status") val status: String? = null,
    @SerialName("species") val species: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("gender") val gender: String? = null,
    @SerialName("origin") val origin: UrlSchemeDto? = null,
    @SerialName("location") val location: UrlSchemeDto? = null,
    @SerialName("image") val image: String? = null,
    @SerialName("episode") val episodeList: List<String>? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("created") val created: String? = null,
)