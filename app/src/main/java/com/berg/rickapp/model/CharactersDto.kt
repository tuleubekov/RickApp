package com.berg.rickapp.model

import com.google.gson.annotations.SerializedName

data class CharacterListDto(
    @SerializedName("info") val info: CharacterListInfoDto? = null,
    @SerializedName("results") val results: List<CharacterDto>? = null,
)

data class CharacterListInfoDto(
    @SerializedName("count") val count: Int? = null,
    @SerializedName("pages") val pages: Int? = null,
    @SerializedName("next") val next: String? = null,
    @SerializedName("prev") val prev: String? = null,
)

data class CharacterDto(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("species") val species: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("gender") val gender: String? = null,
    @SerializedName("origin") val origin: OriginDto? = null,
    @SerializedName("location") val location: LocationDto? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("episode") val episodeList: List<String>? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("created") val created: String? = null,
)