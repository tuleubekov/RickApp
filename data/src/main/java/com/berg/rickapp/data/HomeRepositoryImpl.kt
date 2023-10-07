package com.berg.rickapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.berg.rickapp.data.api.RickApi
import com.berg.rickapp.data.datasource.RemoteDataSource
import com.berg.rickapp.data.pagingsource.CharacterPagingSource
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.random.Random

class HomeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : HomeRepository {

    override suspend fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = CharacterPagingSource.PAGE_SIZE,
                prefetchDistance = CharacterPagingSource.PREFETCH_DISTANCE
            ),
            pagingSourceFactory = { CharacterPagingSource(remoteDataSource) }
        ).flow
    }

    override suspend fun getCharacter(url: String): Character {
        return remoteDataSource.getSingleCharacter(url)
    }

    override suspend fun getMultipleCharacters(count: Int): List<Character> {
        return remoteDataSource.getMultipleCharacters(getRandomArray(count))
    }

    private fun getRandomArray(count: Int): String {
        return generateSequence { Random.nextInt(1, RickApi.MAX_CHARACTERS) }
            .distinct()
            .take(count)
            .joinToString(",")
    }
}