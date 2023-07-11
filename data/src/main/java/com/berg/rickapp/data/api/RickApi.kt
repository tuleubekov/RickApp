package com.berg.rickapp.data.api

import com.berg.rickapp.data.dto.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Url

interface RickApi {

//    @GET("https://rickandmortyapi.com/api/characters")
//    suspend fun getAllCharacters(): CharacterListDto

    @GET
    suspend fun getSingleCharacter(@Url url: String): CharacterDto
}