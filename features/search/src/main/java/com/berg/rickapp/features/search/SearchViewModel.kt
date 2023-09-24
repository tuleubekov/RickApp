package com.berg.rickapp.features.search

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.berg.rickapp.core.presentation.base.BaseViewModel
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.domain.model.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val interactor: HomeInteractor,
) : BaseViewModel() {

    private val _statePagerCharacters = MutableStateFlow(PagingData.empty<Character>())
    val statePagerCharacters: StateFlow<PagingData<Character>> = _statePagerCharacters

    init {
        getPager()
    }

    fun retry() {
        getPager()
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