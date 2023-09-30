package com.berg.rickapp.core.navigation.api.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.berg.rickapp.core.navigation.api.nav.NavigationEvent
import com.berg.rickapp.core.navigation.api.nav.Navigational
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun Fragment.observeNavigationEvent(
    nav: Navigational,
    lifecycle: Lifecycle = viewLifecycleOwner.lifecycle,
    minState: Lifecycle.State = Lifecycle.State.STARTED,
) {
    nav.navigationFlow.onEach {
        when (it) {
            is NavigationEvent.Forward -> {
                requireActivity().findNavController(it.hostId).navigate(it.id)
            }
            is NavigationEvent.Back -> findNavController().navigateUp()
        }
    }
        .flowWithLifecycle(lifecycle = lifecycle, minActiveState = minState)
        .launchIn(viewLifecycleOwner.lifecycleScope)
}