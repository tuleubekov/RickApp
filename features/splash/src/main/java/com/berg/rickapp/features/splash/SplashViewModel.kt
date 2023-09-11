package com.berg.rickapp.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.navigation.api.NavFlowImpl
import com.berg.rickapp.core.navigation.api.NavigationFlow
import com.berg.rickapp.features.splash.router.SplashRouter
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val router: SplashRouter,
) : ViewModel(), NavigationFlow by NavFlowImpl() {

    init {
        viewModelScope.launch {
            sendNavEvent(router.navigateToTabsFragment())
        }
    }
}