package com.berg.rickapp.domain.repositories

import com.google.gson.JsonObject


interface HomeRepository {

    suspend fun getCharacter(): JsonObject
}