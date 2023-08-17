package com.berg.rickapp.common.ui

import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.berg.rickapp.core.navigation.api.NavigationEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun Fragment.isFinishing(): Boolean {
    if (requireActivity().isFinishing) return true

    var anyParentIsRemoving = false
    var parent = parentFragment
    while (!anyParentIsRemoving && parent != null) {
        anyParentIsRemoving = parent.isRemoving
        parent = parent.parentFragment
    }
    return isRemoving || anyParentIsRemoving
}

fun Fragment.setComposeContent(content: @Composable () -> Unit): View {
    return ComposeView(requireContext()).apply {
        setContent { content() }
    }
}

fun Fragment.observeNavigationEvent(event: Flow<NavigationEvent>) {
    event.onEach {
        when(it) {
            is NavigationEvent.Forward -> {
                requireActivity().findNavController(it.hostId).navigate(it.id)
            }
            is NavigationEvent.Back -> { findNavController().navigateUp() }
        }
    }.launchIn(viewLifecycleOwner.lifecycleScope)
}