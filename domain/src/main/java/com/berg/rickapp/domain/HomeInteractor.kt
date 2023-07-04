package com.berg.rickapp.domain

import com.berg.rickapp.domain.repositories.HomeRepository
import com.google.gson.JsonObject
import javax.inject.Inject

interface HomeInteractor {

    suspend fun getCharacter(): JsonObject
}

class HomeInteractorImpl @Inject constructor(
    private val homeRepository: HomeRepository
) : HomeInteractor {

    override suspend fun getCharacter(): JsonObject {
        return homeRepository.getCharacter()
    }

}