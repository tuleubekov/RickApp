package com.berg.rickapp.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.berg.rickapp.core.presentation.utils.isRemovingWithParent
import com.berg.rickapp.details.databinding.FragmentDetailsBinding
import com.berg.rickapp.details.di.DetailsComponent

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val component by lazy { DetailsComponent.get() }
    private val viewModel by viewModels<DetailsViewModel> { component.getViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.get()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isRemovingWithParent()) {
            DetailsComponent.destroy()
        }
    }

}