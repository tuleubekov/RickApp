package com.berg.rickapp.features.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.berg.rickapp.common.ui.observeNavigationEvent
import com.berg.rickapp.core.presentation.base.BaseFragment
import com.berg.rickapp.features.splash.di.SplashComponent
import com.berg.rickapp.features.splash.screen.SplashScreen

class SplashFragment: BaseFragment() {

    private val component by lazy { SplashComponent.initAndGet() }
    private val viewModel by viewModels<SplashViewModel> { component.getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent { SplashScreen() }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNavigationEvent(viewModel.navigationFlow)
    }

    override fun onFullDestroy() {
        SplashComponent.destroy()
    }
}