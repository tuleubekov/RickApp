package com.berg.rickapp.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.navigation.api.nav.Navigational
import com.berg.rickapp.core.navigation.api.nav.NavigationalImpl
import com.berg.rickapp.core.navigation.api.router.SplashRouter
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val router: SplashRouter,
) : ViewModel(), Navigational by NavigationalImpl() {

    init {
        viewModelScope.launch {
            sendNavEvent(router.navigateToTabsFragment())
        }
    }
}