package com.berg.rickapp.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.berg.rickapp.core.BaseFragment
import com.berg.rickapp.home.databinding.FragmentHomeBinding
import com.berg.rickapp.home.di.HomeComponent

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val component by lazy { HomeComponent.getOrCreate() }
    private val viewModel by viewModels<HomeViewModel> { component.viewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.get()
    }

}