package com.berg.rickapp.core.navigation.impl.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.berg.rickapp.common.utils.logE
import com.berg.rickapp.core.di.Injector
import com.berg.rickapp.features.home.HomeFragment
import com.berg.rickapp.features.search.SearchFragment
import com.berg.rickapp.features.splash.SplashFragment
import javax.inject.Inject
import javax.inject.Named

class AppFragmentFactory @Inject constructor(
    //@Named("splash") private val splashInjector: Injector,
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        logE("instantiate clName= $className")
        when (className) {
            SplashFragment::class.java.name -> {
//                splashInjector.initComponent()
            }
            HomeFragment::class.java.name -> {

            }
            SearchFragment::class.java.name -> {

            }
        }
        return super.instantiate(classLoader, className)
    }
}