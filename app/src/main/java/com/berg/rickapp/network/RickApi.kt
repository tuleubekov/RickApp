package com.berg.rickapp.network

import com.berg.rickapp.model.CharacterListDto
import com.google.gson.JsonObject
import retrofit2.http.GET

interface RickApi {

    @GET("https://rickandmortyapi.com/api/characters")
    suspend fun getAllCharacters(): CharacterListDto

    @GET("https://rickandmortyapi.com/api/character/2")
    suspend fun getSingleCharacter(): JsonObject
}