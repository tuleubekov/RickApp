package com.berg.rickapp.core.presentation.core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface Refreshing {
    val isRefreshing: StateFlow<Boolean>
}

class RefreshingImpl : Refreshing {
    private val _isRefreshing = MutableStateFlow(false)

    override val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing
}