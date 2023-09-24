package com.berg.rickapp.core.presentation.core

import androidx.fragment.app.Fragment

class FragmentDestroyChecker(
    private val block: () -> Unit
) {
    private var isStateSaved = false

    fun onStart() {
        isStateSaved = false
    }

    fun onResume() {
        isStateSaved = false
    }

    fun onSaveInstanceState() {
        isStateSaved = true
    }

    fun onDestroy(fragment: Fragment) {
        //We leave the screen and respectively all fragments will be destroyed
        if (fragment.requireActivity().isFinishing) {
            block.invoke()
            return
        }

        // When we rotate device isRemoving() return true for fragment placed in backstack
        // http://stackoverflow.com/questions/34649126/fragment-back-stack-and-isremoving
        if (isStateSaved) {
            isStateSaved = false
            return
        }

        var anyParentIsRemoving = false

        var parent = fragment.parentFragment
        while (!anyParentIsRemoving && parent != null) {
            anyParentIsRemoving = parent.isRemoving
            parent = parent.parentFragment
        }

        if (fragment.isRemoving || anyParentIsRemoving) {
            block.invoke()
        }
    }
}