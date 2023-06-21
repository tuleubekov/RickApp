package com.berg.rickapp.presentation.tabs

import android.os.Bundle
import android.view.View
import com.berg.rickapp.R
import com.berg.rickapp.core.logD
import com.berg.rickapp.core.logE
import com.berg.rickapp.presentation.base.BaseFragment

class ListLocationFragment : BaseFragment(R.layout.fragment_location_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logE("onViewCreated")
    }

}