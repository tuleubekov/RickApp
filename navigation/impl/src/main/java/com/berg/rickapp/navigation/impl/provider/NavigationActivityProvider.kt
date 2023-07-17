package com.berg.rickapp.navigation.impl.provider

import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle
import java.lang.ref.WeakReference

class NavigationActivityProvider(application: Application) {

    private var activityReference: WeakReference<NavigationFragmentProvider>? = null

    init {
        registerActivityCallbacks(application)
    }

    fun get(): NavigationFragmentProvider? = activityReference?.get()

    private fun registerActivityCallbacks(application: Application) {
        application.registerActivityLifecycleCallbacks(
            object : ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, p1: Bundle?) {
                    if (activity is NavigationFragmentProvider) {
                        activityReference = WeakReference(activity)
                    }
                }

                override fun onActivityDestroyed(activity: Activity) {
                    if (activity is NavigationFragmentProvider) {
                        activityReference = null
                    }
                }

                override fun onActivityStarted(p0: Activity) {}

                override fun onActivityResumed(p0: Activity) {}

                override fun onActivityPaused(p0: Activity) {}

                override fun onActivityStopped(p0: Activity) {}

                override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}
            }
        )
    }

}