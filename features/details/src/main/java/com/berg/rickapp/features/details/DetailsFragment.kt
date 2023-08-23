package com.berg.rickapp.features.details

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.berg.rickapp.common.ui.isFinishing
import com.berg.rickapp.common.utils.logE
import com.berg.rickapp.features.details.databinding.FragmentDetailsBinding
import com.berg.rickapp.features.details.di.DetailsComponent

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val component by lazy { DetailsComponent.get() }
    private val viewModel by viewModels<DetailsViewModel> { component.getViewModelFactory() }
    private var isStateSaved = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logE("DetailsFragment onViewCreated")
        viewModel.get()
    }

    override fun onStart() {
        super.onStart()
        isStateSaved = false
    }

    override fun onResume() {
        super.onResume()
        isStateSaved = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        isStateSaved = true
    }

    override fun onDestroy() {
        super.onDestroy()
        logE("DetailsFragment onDestroy")

        //We leave the screen and respectively all fragments will be destroyed
        //We leave the screen and respectively all fragments will be destroyed
        if (activity!!.isFinishing) {
            DetailsComponent.destroy()
            return
        }

        // When we rotate device isRemoving() return true for fragment placed in backstack
        // http://stackoverflow.com/questions/34649126/fragment-back-stack-and-isremoving

        // When we rotate device isRemoving() return true for fragment placed in backstack
        // http://stackoverflow.com/questions/34649126/fragment-back-stack-and-isremoving
        if (isStateSaved) {
            isStateSaved = false
            return
        }

        var anyParentIsRemoving = false

        if (Build.VERSION.SDK_INT >= 25) {
            var parent = parentFragment
            while (!anyParentIsRemoving && parent != null) {
                anyParentIsRemoving = parent.isRemoving
                parent = parent.parentFragment
            }
        }

        if (isRemoving || anyParentIsRemoving) {
            DetailsComponent.destroy()
        }
    }

}