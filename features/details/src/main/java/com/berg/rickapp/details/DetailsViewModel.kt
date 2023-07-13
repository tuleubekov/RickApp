package com.berg.rickapp.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berg.rickapp.core.logE
import com.berg.rickapp.domain.DetailsInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val interactor: DetailsInteractor,
): ViewModel() {

    fun get() {
        viewModelScope.launch {
            kotlin.runCatching {
                interactor.getCharacter("https://rickandmortyapi.com/api/character/1")
            }
                .onSuccess { logE("success= $it") }
                .onFailure { logE("fail= $it") }
        }
    }

}