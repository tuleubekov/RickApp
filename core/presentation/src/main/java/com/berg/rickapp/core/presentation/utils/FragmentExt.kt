package com.berg.rickapp.core.presentation.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.berg.rickapp.core.presentation.nav.NavigationEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun Fragment.isRemovingWithParent(): Boolean {
    return isRemoving || parentFragment?.isRemoving == true
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