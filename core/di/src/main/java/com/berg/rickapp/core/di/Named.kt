package com.berg.rickapp.core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Named(
    val value: String = "",
)
