package com.berg.rickapp.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.navigation.api.NavigationEvent
import com.berg.rickapp.features.splash.router.SplashRouter
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val router: SplashRouter,
) : ViewModel() {

    private val navChannel = Channel<NavigationEvent>(Channel.BUFFERED)
    val navFlow = navChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            navChannel.send(router.navigateToTabsFragment())
        }
    }
}