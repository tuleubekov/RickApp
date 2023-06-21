package com.berg.rickapp.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.berg.rickapp.R
import com.berg.rickapp.core.logD
import com.berg.rickapp.databinding.FragmentMainBinding
import com.berg.rickapp.presentation.base.BaseFragment

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logD("MainFragment onViewCreated")
        _binding = FragmentMainBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.fragment_container)
        setupWithNavController(binding.bottomNavView, navController)
        binding.bottomNavView.itemIconTintList = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}