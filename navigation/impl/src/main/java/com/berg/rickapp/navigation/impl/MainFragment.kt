package com.berg.rickapp.navigation.impl

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.berg.rickapp.core.presentation.BaseFragment
import com.berg.rickapp.core.common.logD
import com.berg.rickapp.navigation.impl.databinding.FragmentMainBinding

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    val navController by lazy {
        (childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logD("MainFragment onViewCreated")
        setupBackButton()
        setupWithNavController(binding.bottomNavView, navController)
        binding.bottomNavView.itemIconTintList = null
    }

    private fun setupBackButton() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (!navController.navigateUp()) {
                        requireActivity().finish()
                    }
                }
            }
        )
    }

}