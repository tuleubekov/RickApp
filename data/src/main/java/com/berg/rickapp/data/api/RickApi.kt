package com.berg.rickapp.data.api

import com.google.gson.JsonObject
import retrofit2.http.GET

interface RickApi {

//    @GET("https://rickandmortyapi.com/api/characters")
//    suspend fun getAllCharacters(): CharacterListDto

    @GET("character/2")
    suspend fun getSingleCharacter(): JsonObject
}