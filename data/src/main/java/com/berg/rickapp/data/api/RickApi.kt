package com.berg.rickapp.data.api

import com.berg.rickapp.data.dto.CharacterDto
import com.berg.rickapp.data.dto.CharacterListDto
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface RickApi {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharacterListDto

    @GET
    suspend fun getAllCharacters(@Url url: String): CharacterListDto

    @GET
    suspend fun getSingleCharacter(@Url url: String): CharacterDto
}