package com.denwehrle.boilerplate.ui.main

import android.os.Bundle
import com.denwehrle.boilerplate.R
import com.denwehrle.boilerplate.ui.base.BaseActivity
import com.denwehrle.boilerplate.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

/**
 * @author Dennis Wehrle
 */
class MainActivity : BaseActivity(), MainMvpView {

    /**
     * To make classed injectable make sure they have a constructor
     * with the @Inject annotation.
     */
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)
        presenter.loadData()
    }


    /********* Mvp Method Implementations *********/

    override fun setUpToolbar() {
        setSupportActionBar(toolbar)
    }

    override fun setUpOnClickListener() {
        btnNext.setOnClickListener {
            presenter.getNextPage()
        }
        btnPrevious.setOnClickListener {
            presenter.getPreviousPage()
        }
    }

    /**
     * We take the loaded data and update the view accordingly.
     */
    override fun showData(message: String) {
        tvPage.text = message
    }

    /**
     * If the data can not be loaded we react to the error accordingly.
     */
    override fun showError() {
        toast("No more pages!")
    }

    /**
     * Make sure to detach the presenter so we don't create a memory leak.
     */
    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
