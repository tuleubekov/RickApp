package com.berg.rickapp.features.home

import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.navigation.api.NavigationApi
import com.berg.rickapp.core.presentation.base.BaseViewModel
import com.berg.rickapp.core.presentation.core.ViewStateDelegate
import com.berg.rickapp.core.presentation.core.ViewStateDelegateImpl
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.features.home.HomeViewModel.UIState
import com.berg.rickapp.features.home.nav.HomeDirections
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val interactor: HomeInteractor,
    private val navApi: NavigationApi<HomeDirections>,
) : BaseViewModel(), ViewStateDelegate<UIState> by ViewStateDelegateImpl(UIState()) {
    companion object {
        private const val ITEM_COUNT = 6
    }

    data class UIState(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val data: List<Character> = emptyList(),
    )

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
            reduce { state -> state.copy(isLoading = true) }
            kotlin.runCatching { interactor.getRandomCharacters(ITEM_COUNT) }
                .onSuccess { reduce { state -> state.copy(data = it) } }
                .onFailure { reduce { state -> state.copy(isError = true) } }
        }.invokeOnCompletion {
            viewModelScope.asyncReduce { state -> state.copy(isLoading = false) }
        }
    }
}