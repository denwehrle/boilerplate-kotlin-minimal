package com.denwehrle.boilerplate.injection.module

import com.denwehrle.boilerplate.injection.scope.PerActivity
import com.denwehrle.boilerplate.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This module is used by the AndroidInjector. Register your activities/fragments and
 * services/receivers here so they can be injected inside the onCreate() methods.
 *
 * @author Dennis Wehrle
 */
@Module
abstract class BindingModule {


    @PerActivity
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}
