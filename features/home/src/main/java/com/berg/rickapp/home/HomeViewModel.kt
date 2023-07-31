package com.berg.rickapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.common.logE
import com.berg.rickapp.navigation.api.NavigationApi
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.home.navigation.HomeDirections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val interactor: HomeInteractor,
    private val navigationApi: NavigationApi<HomeDirections>
) : ViewModel() {

    private val _mStateCharacter = MutableStateFlow("")
    val mStateCharacter: StateFlow<String> = _mStateCharacter

    init {
        get()
    }

    fun gotoDetails() {
        navigationApi.navigate(HomeDirections.ToDetails)
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