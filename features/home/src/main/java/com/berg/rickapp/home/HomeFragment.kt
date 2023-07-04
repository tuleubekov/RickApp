package com.berg.rickapp.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.berg.rickapp.core.BaseFragment
import com.berg.rickapp.core.di.AppViewModelFactory
import com.berg.rickapp.home.databinding.FragmentHomeBinding
import com.berg.rickapp.home.di.inject
import javax.inject.Inject

class HomeFragment : BaseFragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)

    @Inject lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.get()
    }

}