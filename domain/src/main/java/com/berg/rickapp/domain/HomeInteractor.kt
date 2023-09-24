package com.berg.rickapp.domain

import androidx.paging.PagingData
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.random.Random

interface HomeInteractor {
    suspend fun getCharacters(): Flow<PagingData<Character>>
    suspend fun getCharacter(url: String): Character
    suspend fun getRandomCharacters(): List<Character>
}

class HomeInteractorImpl @Inject constructor(
    private val homeRepository: HomeRepository
) : HomeInteractor {

    override suspend fun getCharacters(): Flow<PagingData<Character>> {
        return homeRepository.getCharacters()
    }

    override suspend fun getCharacter(url: String): Character {
        return homeRepository.getCharacter(url)
    }

    override suspend fun getRandomCharacters(): List<Character> {
        return homeRepository.getRandomCharacters(getRandomArray())
    }

    private fun getRandomArray(): String {
        return generateSequence { Random.nextInt(1, 826) }
            .distinct()
            .take(6)
            .toList()
            .toString()
            .filterNot { it.isWhitespace() }
    }
}