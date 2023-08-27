package com.berg.rickapp.core.presentation

import com.berg.rickapp.core.navigation.api.NavigationFlow
import com.berg.rickapp.core.navigation.api.NavigationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class NavFlowImpl : NavigationFlow {
    private val navChannel = Channel<NavigationEvent>(Channel.BUFFERED)

    override val navigationFlow: Flow<NavigationEvent>
        get() = navChannel.receiveAsFlow()

    override suspend fun sendNavEvent(event: NavigationEvent) = navChannel.send(event)
}