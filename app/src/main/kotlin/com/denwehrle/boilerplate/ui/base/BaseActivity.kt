package com.denwehrle.boilerplate.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.denwehrle.boilerplate.injection.module.BindingModule
import dagger.android.AndroidInjection

/**
 * @author Dennis Wehrle
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * For AndroidInjection.inject(this) to work the [AppCompatActivity] has to be registered
     * in the [BindingModule]. Make sure it's called before super.onCreate() to
     * prevent unexpected crashed if the task gets suspended by the OS.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}