package com.berg.rickapp.core.presentation.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class AppFragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        when (className) {

        }
        return super.instantiate(classLoader, className)
    }
}