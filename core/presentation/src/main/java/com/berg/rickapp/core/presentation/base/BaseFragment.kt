package com.berg.rickapp.core.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.berg.rickapp.core.presentation.core.FragmentDestroyChecker

open class BaseFragment : Fragment() {
    private val destroyChecker = FragmentDestroyChecker(::onFullDestroy)

    override fun onStart() {
        super.onStart()
        destroyChecker.onStart()
    }

    override fun onResume() {
        super.onResume()
        destroyChecker.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        destroyChecker.onSaveInstanceState()
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyChecker.onDestroy(this)
    }

    protected open fun onFullDestroy() { }

}