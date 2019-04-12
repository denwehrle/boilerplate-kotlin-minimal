package com.denwehrle.boilerplate.ui.main

import com.denwehrle.boilerplate.data.DataManager
import com.denwehrle.boilerplate.ui.base.BasePresenter
import javax.inject.Inject

/**
 * @author Dennis Wehrle
 */
class MainPresenter @Inject constructor(private val dataManager: DataManager) : BasePresenter<MainMvpView>() {

    private var pagePosition = 0

    /**
     * If we attach the Presenter there are tasks we can start regardless
     * the specific data, so let's do this here.
     */
    override fun attachView(mvpView: MainMvpView) {
        super.attachView(mvpView)

        this.mvpView.setUpToolbar()
        this.mvpView.setUpOnClickListener()
    }

    fun loadData() {
        mvpView.showData(dataManager.getExampleDataByPosition(pagePosition))
    }

    fun getNextPage() {
        if (pagePosition < dataManager.getExampleDataSize() - 1) {
            pagePosition++
            mvpView.showData(dataManager.getExampleDataByPosition(pagePosition))
        } else {
            mvpView.showError()
        }
    }

    fun getPreviousPage() {
        if (pagePosition != 0) {
            pagePosition--
            mvpView.showData(dataManager.getExampleDataByPosition(pagePosition))
        } else {
            mvpView.showError()
        }
    }
}
