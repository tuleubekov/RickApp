package com.berg.rickapp.domain

import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.domain.repositories.HomeRepository
import javax.inject.Inject

interface DetailsInteractor {
    suspend fun getCharacter(url: String): Character
}

class DetailsInteractorImpl @Inject constructor(
    private val repository: HomeRepository,
) : DetailsInteractor {

    override suspend fun getCharacter(url: String): Character {
        return repository.getCharacter(url)
    }

}