package com.berg.rickapp.features.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berg.rickapp.common.utils.logE
import com.berg.rickapp.domain.HomeInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val interactor: HomeInteractor,
): ViewModel() {

    private val _mStateCharacter = MutableStateFlow("")
    val mStateCharacter: StateFlow<String> = _mStateCharacter

    init {
        get()
    }

    private fun get() {
        viewModelScope.launch {
            kotlin.runCatching {
                interactor.getCharacter("https://rickandmortyapi.com/api/character/1")
            }
                .onSuccess {
                    _mStateCharacter.value = it.name
                }
                .onFailure { logE("fail= $it") }
        }
    }

}