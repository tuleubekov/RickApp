package com.berg.rickapp.core.navigation.impl.base

import android.content.Context
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AppNavHostFragment : NavHostFragment() {

    //@Inject lateinit var fragmentFactory: AppFragmentFactory

    override fun onAttach(context: Context) {
        //AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //childFragmentManager.fragmentFactory = fragmentFactory
        super.onCreate(savedInstanceState)
    }
}