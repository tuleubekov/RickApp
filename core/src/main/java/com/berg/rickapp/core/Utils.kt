package com.berg.rickapp.core

import timber.log.Timber

fun Any.logE(e: String) = Timber.e(e)

fun Any.logD(m: String) = Timber.d(m)

fun Any.timberDebug() = Timber.plant(Timber.DebugTree())