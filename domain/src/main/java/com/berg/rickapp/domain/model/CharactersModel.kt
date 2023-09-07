package com.berg.rickapp.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: UrlSchemeModel,
    val location: UrlSchemeModel,
    val image: String,
    val episodeList: List<String>,
    val url: String,
    val created: String,
)

data class CharacterList(
    val pageInfo: CharacterListInfo,
    val characters: List<Character>,
)

data class CharacterListInfo(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String,
)