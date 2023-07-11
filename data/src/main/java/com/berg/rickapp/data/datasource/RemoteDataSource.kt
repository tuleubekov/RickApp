package com.berg.rickapp.data.datasource

import com.berg.rickapp.data.api.RickApi
import com.berg.rickapp.data.mapper.CharacterMapper
import com.berg.rickapp.data.mapper.DefaultCharacterMapper
import com.berg.rickapp.domain.model.Character
import javax.inject.Inject

interface RemoteDataSource {
    suspend fun getSingleCharacter(): Character
}

class RemoteDataSourceImpl @Inject constructor(
    private val api: RickApi,
): RemoteDataSource {

    private val mapper: CharacterMapper = DefaultCharacterMapper()

    override suspend fun getSingleCharacter(): Character {
        return api.getSingleCharacter().let(mapper::map)
    }
}