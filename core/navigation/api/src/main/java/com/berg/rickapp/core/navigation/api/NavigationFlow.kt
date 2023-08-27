package com.berg.rickapp.core.navigation.api

import kotlinx.coroutines.flow.Flow

interface NavigationFlow {
    val navigationFlow: Flow<NavigationEvent>

    suspend fun sendNavEvent(event: NavigationEvent)
}