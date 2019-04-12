package com.denwehrle.boilerplate.ui.main

import com.denwehrle.boilerplate.ui.base.MvpView

/**
 * @author Dennis Wehrle
 */
interface MainMvpView : MvpView {

    fun setUpToolbar()

    fun setUpOnClickListener()

    fun showData(message: String)

    fun showError()
}
