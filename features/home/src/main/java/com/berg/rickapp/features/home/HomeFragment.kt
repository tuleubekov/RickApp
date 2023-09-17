package com.berg.rickapp.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.berg.rickapp.common.ui.observeNavigationEvent
import com.berg.rickapp.common.ui.setComposeContent
import com.berg.rickapp.core.presentation.base.BaseFragment
import com.berg.rickapp.features.home.di.HomeComponent
import com.berg.rickapp.features.home.screen.HomeScreenRoot

class HomeFragment : BaseFragment() {
    private val component by lazy { HomeComponent.get() }
    private val viewModel by viewModels<HomeViewModel> { component.getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setComposeContent { HomeScreenRoot(viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNavigationEvent(viewModel)
    }

    override fun onFullDestroy() {
        HomeComponent.destroy()
    }
}