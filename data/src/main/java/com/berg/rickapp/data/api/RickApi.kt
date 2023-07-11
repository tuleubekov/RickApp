package com.berg.rickapp.data.api

import com.berg.rickapp.data.dto.CharacterDto
import retrofit2.http.GET

interface RickApi {

//    @GET("https://rickandmortyapi.com/api/characters")
//    suspend fun getAllCharacters(): CharacterListDto

    @GET("character/2")
    suspend fun getSingleCharacter(): CharacterDto
}