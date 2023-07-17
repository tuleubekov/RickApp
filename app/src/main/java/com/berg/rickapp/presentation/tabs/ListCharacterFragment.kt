package com.berg.rickapp.presentation.tabs

import android.os.Bundle
import android.view.View
import com.berg.rickapp.R
import com.berg.rickapp.core.common.logD
import com.berg.rickapp.core.presentation.BaseFragment

class ListCharacterFragment : BaseFragment(R.layout.fragment_character_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logD("onViewCreated")
    }
}