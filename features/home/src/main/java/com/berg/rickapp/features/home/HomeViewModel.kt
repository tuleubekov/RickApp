package com.berg.rickapp.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berg.rickapp.common.utils.logE
import com.berg.rickapp.core.navigation.api.NavigationFlow
import com.berg.rickapp.core.presentation.NavFlowImpl
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.features.home.router.HomeRouter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val interactor: HomeInteractor,
    private val router: HomeRouter,
) : ViewModel(), NavigationFlow by NavFlowImpl() {

    private val _mStateCharacter = MutableStateFlow("")
    val mStateCharacter: StateFlow<String> = _mStateCharacter

    init {
        get()
    }

    fun gotoDetails() {
        viewModelScope.launch { sendNavEvent(router.navigateToDetails()) }
    }

    fun gotoAbout() {
        viewModelScope.launch { sendNavEvent(router.navigateToAbout()) }
    }

    private fun get() {
        viewModelScope.launch {
            kotlin.runCatching {
                interactor.getCharacter("https://rickandmortyapi.com/api/character/2")
            }
                .onSuccess {
                    logE("success= $it")
                    _mStateCharacter.value = it.name
                }
                .onFailure { logE("fail= $it") }
        }
    }
}