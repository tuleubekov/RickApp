package com.berg.rickapp.features.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.berg.rickapp.common.ui.setComposeContent
import com.berg.rickapp.core.presentation.base.BaseFragment
import com.berg.rickapp.features.search.di.SearchComponent
import com.berg.rickapp.features.search.screen.SearchScreenRoot

class SearchFragment : BaseFragment() {
    private val component by lazy { SearchComponent.get() }
    private val viewModel by viewModels<SearchViewModel> { component.getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return setComposeContent { SearchScreenRoot(viewModel = viewModel) }
    }

    override fun onFullDestroy() {
        SearchComponent.get()
    }

}