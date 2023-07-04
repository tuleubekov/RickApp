package com.berg.rickapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.logE
import com.berg.rickapp.domain.HomeInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val interactor: HomeInteractor,
) : ViewModel() {

    fun get() {
        viewModelScope.launch {
            kotlin.runCatching { interactor.getCharacter() }
                .onSuccess { logE("success= $it") }
                .onFailure { logE("fail= $it") }
        }
    }
}