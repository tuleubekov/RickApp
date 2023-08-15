package com.berg.rickapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.berg.rickapp.core.presentation.utils.isRemovingWithParent
import com.berg.rickapp.core.presentation.utils.observeNavigationEvent
import com.berg.rickapp.home.di.HomeComponent
import com.berg.rickapp.home.screen.HomeScreenRoot

class HomeFragment : Fragment() {

    private val component by lazy { HomeComponent.getOrCreate() }
    private val viewModel by viewModels<HomeViewModel> { component.getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent { HomeScreenRoot(viewModel) }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNavigationEvent(viewModel.navFlow)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isRemovingWithParent()) {
            HomeComponent.destroy()
        }
    }

}