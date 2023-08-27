package com.berg.rickapp.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.berg.rickapp.common.ui.isFinishing
import com.berg.rickapp.common.ui.observeNavigationEvent
import com.berg.rickapp.common.ui.setComposeContent
import com.berg.rickapp.features.home.di.HomeComponent
import com.berg.rickapp.features.home.screen.HomeScreenRoot

class HomeFragment : Fragment() {

    private val component by lazy { HomeComponent.get() }
    private val viewModel by viewModels<HomeViewModel> { component.getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setComposeContent { HomeScreenRoot(viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNavigationEvent(viewModel.navigationFlow)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing()) HomeComponent.destroy()
    }

}