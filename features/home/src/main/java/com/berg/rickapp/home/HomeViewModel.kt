package com.berg.rickapp.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.logE
import com.berg.rickapp.core.navigation.NavigationApi
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.home.navigation.HomeDirections
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val interactor: HomeInteractor,
    private val navigationApi: NavigationApi<HomeDirections>
) : ViewModel() {

    val mCharacter = MutableLiveData<String>()

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
                    mCharacter.value = it.name
                }
                .onFailure { logE("fail= $it") }
        }
    }
}