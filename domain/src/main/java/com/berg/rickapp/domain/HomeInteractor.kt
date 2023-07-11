package com.berg.rickapp.domain

import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.domain.repositories.HomeRepository
import javax.inject.Inject

interface HomeInteractor {

    suspend fun getCharacter(url: String): Character
}

class HomeInteractorImpl @Inject constructor(
    private val homeRepository: HomeRepository
) : HomeInteractor {

    override suspend fun getCharacter(url: String): Character {
        return homeRepository.getCharacter(url)
    }

}