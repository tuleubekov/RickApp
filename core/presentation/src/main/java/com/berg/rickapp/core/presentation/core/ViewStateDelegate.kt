package com.berg.rickapp.core.presentation.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

interface ViewStateDelegate<UIState> {

    val uiState: Flow<UIState>

    val stateValue: UIState

    suspend fun reduce(action: (currentState: UIState) -> UIState)

    fun CoroutineScope.asyncReduce(action: (currentState: UIState) -> UIState)
}

class ViewStateDelegateImpl<UIState>(
    initialUiState: UIState,
) : ViewStateDelegate<UIState> {

    private val _uiStateFlow = MutableStateFlow(initialUiState)
    private val mutex = Mutex()

    override val uiState: Flow<UIState>
        get() = _uiStateFlow.asStateFlow()

    override val stateValue: UIState
        get() = _uiStateFlow.value

    override suspend fun reduce(action: (currentState: UIState) -> UIState) {
        mutex.withLock {
            _uiStateFlow.emit(action(stateValue))
        }
    }

    override fun CoroutineScope.asyncReduce(action: (currentState: UIState) -> UIState) {
        launch { reduce(action) }
    }
}