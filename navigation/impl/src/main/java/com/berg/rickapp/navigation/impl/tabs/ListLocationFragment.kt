package com.berg.rickapp.navigation.impl.tabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.berg.rickapp.core.common.logE
import com.berg.rickapp.navigation.impl.R

class ListLocationFragment : Fragment(R.layout.fragment_location_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logE("onViewCreated")
    }

}