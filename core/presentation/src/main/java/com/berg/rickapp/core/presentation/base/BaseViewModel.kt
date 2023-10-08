package com.berg.rickapp.core.presentation.base

import androidx.lifecycle.ViewModel
import com.berg.rickapp.core.navigation.api.nav.Navigational
import com.berg.rickapp.core.navigation.api.nav.NavigationalImpl

open class BaseViewModel : ViewModel(),
    Navigational by NavigationalImpl()