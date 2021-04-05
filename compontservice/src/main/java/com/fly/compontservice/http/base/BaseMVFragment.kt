package com.fly.compontservice.http.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.fly.baselibrary.base.BaseFragment

abstract class BaseMVFragment<VM : BaseViewModel<T>, T> : BaseFragment() {

    private val fragmentName = javaClass::getSimpleName

    protected lateinit var viewModel: VM


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initVM()
        super.onViewCreated(view, savedInstanceState)
        startObserve()
    }

    private fun initVM() {
        providerVmClass()?.let {
            viewModel = ViewModelProviders.of(this).get(it)
            lifecycle.addObserver(viewModel)
        }
    }

    open fun providerVmClass(): Class<VM>? = null

    open fun startObserve() {

    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::viewModel.isInitialized){
            lifecycle.removeObserver(viewModel)
        }
    }
}