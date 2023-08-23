package com.berg.rickapp.features.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.berg.rickapp.common.ui.isFinishing
import com.berg.rickapp.common.ui.observeNavigationEvent
import com.berg.rickapp.common.ui.repeatJob
import com.berg.rickapp.features.splash.di.SplashComponent
import com.berg.rickapp.features.splash.screen.SplashScreen
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch

class SplashFragment: Fragment() {

    private val component by lazy { SplashComponent.get() }
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
        observeNavigationEvent(viewModel.navFlow)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing()) SplashComponent.destroy()
    }
}