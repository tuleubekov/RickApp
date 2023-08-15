package com.berg.rickapp.navigation.impl

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.berg.rickapp.core.common.logD
import com.berg.rickapp.navigation.impl.databinding.FragmentTabsBinding

class TabsFragment : Fragment(R.layout.fragment_tabs) {

    private val binding by viewBinding(FragmentTabsBinding::bind)

    val navController by lazy {
        (childFragmentManager.findFragmentById(R.id.tabs_host_fragment) as NavHostFragment).navController
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("TabsFragment", "TabsFragment onViewCreated graphId= ${navController.graph.id}")
        logD("MainFragment onViewCreated")

        setupWithNavController(binding.bottomNavView, navController)
        binding.bottomNavView.itemIconTintList = null
    }

}