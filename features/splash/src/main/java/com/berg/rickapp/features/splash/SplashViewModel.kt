package com.berg.rickapp.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.navigation.api.nav.NavFlow
import com.berg.rickapp.core.navigation.api.nav.NavFlowImpl
import com.berg.rickapp.core.navigation.api.router.SplashRouter
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val router: SplashRouter,
) : ViewModel(), NavFlow by NavFlowImpl() {

    init {
        viewModelScope.launch {
            sendNavEvent(router.navigateToTabsFragment())
        }
    }
}