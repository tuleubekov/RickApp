package com.berg.rickapp.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.navigation.api.nav.NavFlow
import com.berg.rickapp.core.navigation.api.nav.NavFlowImpl
import com.berg.rickapp.core.navigation.api.router.HomeRouter
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.domain.model.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val interactor: HomeInteractor,
    private val router: HomeRouter,
) : ViewModel(), NavFlow by NavFlowImpl() {

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    private val _stateRandomCharacters = MutableStateFlow(emptyList<Character>())
    val stateRandomCharacters: StateFlow<List<Character>> = _stateRandomCharacters

    init {
        getRandomCharacters()
    }

    fun retry() {
        getRandomCharacters()
    }

    fun gotoDetails() {
        viewModelScope.launch { sendNavEvent(router.navigateToDetails()) }
    }

    fun gotoAbout() {
        viewModelScope.launch { sendNavEvent(router.navigateToAbout()) }
    }

    private fun getRandomCharacters() {
        viewModelScope.launch {
            kotlin.runCatching { interactor.getRandomCharacters() }
                .onSuccess { _stateRandomCharacters.value = it }
                .onFailure { _stateRandomCharacters.value = emptyList() }
        }
    }
}