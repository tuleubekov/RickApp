package com.berg.rickapp.data.datasource

import com.berg.rickapp.data.api.RickApi
import com.berg.rickapp.data.mapper.CharacterMapper
import com.berg.rickapp.data.mapper.CharactersMapper
import com.berg.rickapp.data.mapper.DefaultCharacterMapper
import com.berg.rickapp.data.mapper.DefaultCharactersMapper
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.domain.model.CharacterList
import javax.inject.Inject

interface RemoteDataSource {
    suspend fun getCharacters(page: Int): CharacterList
    suspend fun getAllCharacters(url: String): CharacterList
    suspend fun getSingleCharacter(url: String): Character
    suspend fun getMultipleCharacters(idsString: String): List<Character>
}

class RemoteDataSourceImpl @Inject constructor(
    private val api: RickApi,
): RemoteDataSource {

    private val mapper: CharacterMapper = DefaultCharacterMapper()
    private val listMapper: CharactersMapper = DefaultCharactersMapper()

    override suspend fun getCharacters(page: Int): CharacterList {
        return api.getCharacters(page).let(listMapper::map)
    }
    override suspend fun getAllCharacters(url: String): CharacterList {
        return api.getAllCharacters(url).let(listMapper::map)
    }

    override suspend fun getSingleCharacter(url: String): Character {
        return api.getSingleCharacter(url).let(mapper::map)
    }

    override suspend fun getMultipleCharacters(idsString: String): List<Character> {
        return api.getMultipleCharacters(idsString).map(mapper::map)
    }
}