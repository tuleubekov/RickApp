package com.berg.rickapp.core.navigation.api.nav

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

interface NavFlow {
    val navigationFlow: Flow<NavigationEvent>

    suspend fun sendNavEvent(event: NavigationEvent)
}

class NavFlowImpl : NavFlow {
    private val navChannel = Channel<NavigationEvent>(Channel.BUFFERED)

    override val navigationFlow: Flow<NavigationEvent>
        get() = navChannel.receiveAsFlow()

    override suspend fun sendNavEvent(event: NavigationEvent) = navChannel.send(event)
}