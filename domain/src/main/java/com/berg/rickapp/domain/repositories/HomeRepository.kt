package com.berg.rickapp.domain.repositories

import androidx.paging.PagingData
import com.berg.rickapp.domain.model.Character
import kotlinx.coroutines.flow.Flow


interface HomeRepository {
    suspend fun getCharacters(): Flow<PagingData<Character>>
    suspend fun getCharacter(url: String): Character
}