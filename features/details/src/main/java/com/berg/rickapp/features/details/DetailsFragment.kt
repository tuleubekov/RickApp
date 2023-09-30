package com.berg.rickapp.features.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.berg.rickapp.common.ui.setComposeContent
import com.berg.rickapp.core.presentation.base.BaseFragment
import com.berg.rickapp.features.details.di.DetailsComponent
import com.berg.rickapp.features.details.screen.DetailsScreenRoot

class DetailsFragment : BaseFragment() {
    private val component by lazy { DetailsComponent.get() }
    private val viewModel by viewModels<DetailsViewModel> { component.getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return setComposeContent { DetailsScreenRoot(viewModel) }
    }

    override fun onFullDestroy() {
        DetailsComponent.destroy()
    }
}