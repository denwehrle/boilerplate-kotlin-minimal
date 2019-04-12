package com.denwehrle.boilerplate

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import androidx.multidex.MultiDex
import androidx.fragment.app.Fragment
import com.denwehrle.boilerplate.injection.component.DaggerAppComponent
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Dennis Wehrle
 */
class App : Application(), HasActivityInjector {

    /**
     * We register our injectors, so we can inject all type of objects
     * inside our classes later. These injectors use the provider methods
     * defined in the /injection folder.
     */
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)

        setUpDebugUtils()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    private fun setUpDebugUtils() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }
}