package com.berg.rickapp.navigation.impl.tempFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.berg.rickapp.navigation.impl.R

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
        requireActivity().findNavController(R.id.root_nav_host).navigateUp()
        findNavController()
    }
}