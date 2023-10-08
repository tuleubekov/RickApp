package com.berg.rickapp.core.presentation.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.berg.rickapp.core.presentation.core.ViewStateDelegate

@Composable
fun <T> ViewStateDelegate<T>.collectUIStateWithLifecycle(
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
) = this.uiState.collectAsStateWithLifecycle(
    initialValue = this.stateValue,
    minActiveState = minActiveState,
)