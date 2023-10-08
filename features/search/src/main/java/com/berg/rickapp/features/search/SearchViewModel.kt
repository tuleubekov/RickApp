package com.berg.rickapp.features.search

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.berg.rickapp.core.presentation.base.BaseViewModel
import com.berg.rickapp.core.presentation.core.ViewStateDelegate
import com.berg.rickapp.core.presentation.core.ViewStateDelegateImpl
import com.berg.rickapp.domain.HomeInteractor
import com.berg.rickapp.domain.model.Character
import com.berg.rickapp.features.search.SearchViewModel.UIState
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val interactor: HomeInteractor,
) : BaseViewModel(), ViewStateDelegate<UIState> by ViewStateDelegateImpl(UIState()) {

    data class UIState(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val data: PagingData<Character> = PagingData.empty(),
    )

    init {
        getPager()
    }

    fun retry() = getPager()

    private fun getPager() {
        viewModelScope.launch {
            reduce { state -> state.copy(isLoading = true) }
            interactor.getCharacters()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {
                    reduce { state -> state.copy(data = it, isLoading = false) }
                }
        }.invokeOnCompletion {
            viewModelScope.asyncReduce { state -> state.copy(isLoading = false) }
        }
    }
}