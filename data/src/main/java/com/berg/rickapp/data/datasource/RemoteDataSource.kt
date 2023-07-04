package com.berg.rickapp.data.datasource

import com.berg.rickapp.data.api.RickApi
import com.google.gson.JsonObject
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: RickApi,
) {

    suspend fun getSingleCharacter(): JsonObject {
        return api.getSingleCharacter()
    }
}