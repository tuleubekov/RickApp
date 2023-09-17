package com.berg.rickapp.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.berg.rickapp.core.navigation.api.nav.NavFlow
import com.berg.rickapp.core.navigation.api.nav.NavFlowImpl
import com.berg.rickapp.core.navigation.api.router.HomeRouter
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.domain.model.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val interactor: HomeInteractor,
    private val router: HomeRouter,
) : ViewModel(), NavFlow by NavFlowImpl() {

    private val _statePagerCharacters = MutableStateFlow(PagingData.empty<Character>())
    val statePagerCharacters: StateFlow<PagingData<Character>> = _statePagerCharacters

    init {
        getPager()
    }

    fun retry() {
        getPager()
    }

    fun gotoDetails() {
        viewModelScope.launch { sendNavEvent(router.navigateToDetails()) }
    }

    fun gotoAbout() {
        viewModelScope.launch { sendNavEvent(router.navigateToAbout()) }
    }

    private fun getPager() {
        viewModelScope.launch {
            interactor.getCharacters()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {
                    _statePagerCharacters.value = it
                }
        }
    }
}