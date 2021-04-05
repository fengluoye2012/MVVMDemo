package com.fly.compontservice.http.base

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fly.baselibrary.base.BaseActivity
import com.fly.compontservice.http.model.ErrorModel

//指定泛型范围
 abstract class BaseVMActivity<VM : BaseViewModel<T>, T> : BaseActivity() {

    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        initVM()
        super.onCreate(savedInstanceState)
        startObserve()
    }


    private fun initVM() {
        providerVMClass()?.let {
            viewModel = ViewModelProviders.of(this@BaseVMActivity).get(it)
            lifecycle.addObserver(viewModel)
        }
    }

    open fun providerVMClass(): Class<VM>? = null

    private fun startObserve() {
        //处理一些通用异常，比如网络超时、无网等
        viewModel.run {
            getFailed().observe(this@BaseVMActivity, Observer {
                requestError(it)
            })

            getSuccess().observe(this@BaseVMActivity, Observer {
                requestSuccess(it)
            })
        }
    }

    open fun requestError(it: ErrorModel?) {
        it.run {

        }
    }

    open fun requestSuccess(it: T?) {

    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::viewModel.isInitialized) {
            lifecycle.removeObserver(viewModel)
        }
    }
}