package com.berg.rickapp.core.presentation.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.berg.rickapp.common.utils.logE

class LifecycleStateObserver(
    private val fragment: Fragment,
) : DefaultLifecycleObserver {

    private var isStateSaved = false

    override fun onCreate(owner: LifecycleOwner) {
        logE("LifecycleStateObserver, onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        logE("LifecycleStateObserver, onStart")
        isStateSaved = false
    }

    override fun onResume(owner: LifecycleOwner) {
        logE("LifecycleStateObserver, onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        logE("LifecycleStateObserver, onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        logE("LifecycleStateObserver, onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        logE("LifecycleStateObserver, onDestroy")

    }
}