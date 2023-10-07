package com.berg.rickapp.data.api

import com.berg.rickapp.data.dto.CharacterDto
import com.berg.rickapp.data.dto.CharacterListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface RickApi {

    companion object {
        const val MAX_CHARACTERS = 826
    }

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharacterListDto

    @GET("character/{idsArray}")
    suspend fun getMultipleCharacters(@Path("idsArray") ids: String): List<CharacterDto>

    @GET
    suspend fun getAllCharacters(@Url url: String): CharacterListDto

    @GET
    suspend fun getSingleCharacter(@Url url: String): CharacterDto
}