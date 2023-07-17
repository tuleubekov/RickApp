package com.berg.rickapp.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.berg.rickapp.core.presentation.BaseFragment
import com.berg.rickapp.details.databinding.FragmentDetailsBinding
import com.berg.rickapp.details.di.DetailsComponent

class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val component by lazy { DetailsComponent.getOrCreate() }
    private val viewModel by viewModels<DetailsViewModel> { component.getViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.get()
    }

    override fun onDestroy() {
        super.onDestroy()
        DetailsComponent.destroy()
    }

}