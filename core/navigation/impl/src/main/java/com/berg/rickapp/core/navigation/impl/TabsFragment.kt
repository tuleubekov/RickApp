package com.berg.rickapp.core.navigation.impl

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.berg.rickapp.core.navigation.impl.databinding.FragmentTabsBinding

class TabsFragment : Fragment(R.layout.fragment_tabs) {

    private val binding by viewBinding(FragmentTabsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHost =
            (childFragmentManager.findFragmentById(R.id.tabs_host_fragment) as NavHostFragment)

        binding.bottomNavView.setupWithNavController(navHost.navController)
        binding.bottomNavView.itemIconTintList = null
    }

}