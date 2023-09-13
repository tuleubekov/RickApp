package com.berg.rickapp.core.presentation.di

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class FragmentKey(val classKey: KClass<out Fragment>)
