package com.berg.rickapp.core.common.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Named(
    val value: String = "",
)
