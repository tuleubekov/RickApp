package com.berg.rickapp.features.home

import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.navigation.api.NavigationApi
import com.berg.rickapp.core.presentation.base.BaseViewModel
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.features.home.nav.HomeDirections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val interactor: HomeInteractor,
    private val navApi: NavigationApi<HomeDirections>,
) : BaseViewModel() {

    private val _stateRandomCharacters = MutableStateFlow(emptyList<Character>())
    val stateRandomCharacters: StateFlow<List<Character>> = _stateRandomCharacters

    init {
        getRandomCharacters()
    }

    fun retry() {
        getRandomCharacters()
    }

    fun gotoDetails() {
        viewModelScope.launch { sendNavEvent(navApi.direct(HomeDirections.ToDetails)) }
    }

    fun gotoAbout() {
        viewModelScope.launch { sendNavEvent(navApi.direct(HomeDirections.ToAbout)) }
    }

    private fun getRandomCharacters() {
        viewModelScope.launch {
            kotlin.runCatching { interactor.getRandomCharacters() }
                .onSuccess { _stateRandomCharacters.value = it }
                .onFailure { _stateRandomCharacters.value = emptyList() }
        }
    }
}