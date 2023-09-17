package com.berg.rickapp.features.tabs.temp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.berg.rickapp.core.navigation.api.util.navApiR_id

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent { AboutScreen { back() } }
        }
    }

    private fun back() {
        requireActivity().findNavController(navApiR_id.root_nav_host).navigateUp()
    }
}