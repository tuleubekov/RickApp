package com.berg.rickapp.domain

import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.domain.repositories.HomeRepository
import javax.inject.Inject

interface HomeInteractor {

    suspend fun getCharacter(): Character
}

class HomeInteractorImpl @Inject constructor(
    private val homeRepository: HomeRepository
) : HomeInteractor {

    override suspend fun getCharacter(): Character {
        return homeRepository.getCharacter()
    }

}