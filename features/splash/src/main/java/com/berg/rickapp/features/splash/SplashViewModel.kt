package com.berg.rickapp.features.splash

import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.navigation.api.NavigationApi
import com.berg.rickapp.core.presentation.base.BaseViewModel
import com.berg.rickapp.features.splash.nav.SplashDirections
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val navApi: NavigationApi<SplashDirections>,
) : BaseViewModel() {

    init {
        viewModelScope.launch {
            sendNavEvent(navApi.direct(SplashDirections.ToTabs))
        }
    }
}