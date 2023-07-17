package com.berg.rickapp.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.berg.rickapp.R
import com.berg.rickapp.core.BaseFragment
import com.berg.rickapp.core.logD
import com.berg.rickapp.databinding.FragmentMainBinding

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    val navController by lazy {
        (childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logD("MainFragment onViewCreated")
        _binding = FragmentMainBinding.bind(view)
        setupBackButton()
        setupWithNavController(binding.bottomNavView, navController)
        binding.bottomNavView.itemIconTintList = null
    }

    private fun setupBackButton() {
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (!navController.navigateUp()) {
                        activity?.finish()
                    }
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}