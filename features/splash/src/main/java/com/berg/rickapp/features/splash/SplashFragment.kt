package com.berg.rickapp.features.splash

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.berg.rickapp.common.ui.observeNavigationEvent
import com.berg.rickapp.common.utils.logE
import com.berg.rickapp.features.splash.di.SplashComponent
import com.berg.rickapp.features.splash.screen.SplashScreen

class SplashFragment: Fragment() {

    private val component by lazy { SplashComponent.initAndGet() }
    private val viewModel by viewModels<SplashViewModel> { component.getViewModelFactory() }
    private var isStateSaved = false

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

    override fun onStart() {
        super.onStart()
        isStateSaved = false
    }

    override fun onResume() {
        super.onResume()
        isStateSaved = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        isStateSaved = true
    }

    override fun onDestroy() {
        super.onDestroy()
        logE("SplashFragment onDestroy")

        //We leave the screen and respectively all fragments will be destroyed
        //We leave the screen and respectively all fragments will be destroyed
        if (activity!!.isFinishing) {
            SplashComponent.destroy()
            return
        }

        // When we rotate device isRemoving() return true for fragment placed in backstack
        // http://stackoverflow.com/questions/34649126/fragment-back-stack-and-isremoving

        // When we rotate device isRemoving() return true for fragment placed in backstack
        // http://stackoverflow.com/questions/34649126/fragment-back-stack-and-isremoving
        if (isStateSaved) {
            isStateSaved = false
            return
        }

        var anyParentIsRemoving = false

        if (Build.VERSION.SDK_INT >= 25) {
            var parent = parentFragment
            while (!anyParentIsRemoving && parent != null) {
                anyParentIsRemoving = parent.isRemoving
                parent = parent.parentFragment
            }
        }

        if (isRemoving || anyParentIsRemoving) {
            SplashComponent.destroy()
        }
    }
}