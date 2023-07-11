package com.berg.rickapp.data

import com.berg.rickapp.data.datasource.RemoteDataSource
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.domain.repositories.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : HomeRepository {

    override suspend fun getCharacter(url: String): Character {
        return remoteDataSource.getSingleCharacter(url)
    }

}