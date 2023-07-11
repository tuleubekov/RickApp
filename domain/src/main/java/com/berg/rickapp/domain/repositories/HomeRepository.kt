package com.berg.rickapp.domain.repositories

import com.berg.rickapp.domain.model.Character


interface HomeRepository {
    suspend fun getCharacter(url: String): Character
}