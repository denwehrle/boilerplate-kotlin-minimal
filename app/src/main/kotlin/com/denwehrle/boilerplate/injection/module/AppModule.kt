package com.denwehrle.boilerplate.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Module used to provide dependencies at an application-level.
 *
 * @author Dennis Wehrle
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}
