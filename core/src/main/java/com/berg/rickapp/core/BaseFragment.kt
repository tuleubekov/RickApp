package com.berg.rickapp.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import timber.log.Timber

open class BaseFragment(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag(javaClass.simpleName)
    }

}