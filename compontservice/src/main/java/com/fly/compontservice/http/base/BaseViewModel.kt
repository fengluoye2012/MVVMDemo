package com.fly.compontservice.http.base

import androidx.lifecycle.*
import com.blankj.utilcode.util.Utils
import com.fly.compontservice.http.model.ErrorModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class BaseViewModel<T> : AndroidViewModel(Utils.getApp()), LifecycleObserver {


    private val error by lazy {
        MutableLiveData<ErrorModel>()
    }

    private val finally by lazy {
        MutableLiveData<T>()
    }


    fun launchUI(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch {
        //todo 网络请求 正常开发一般不建议直接通过ViewModel获取网络数据，这里我们将工作交给一个新的模块Repository

    }


    fun getFailed(): LiveData<ErrorModel> {
        return error
    }

    fun getSuccess(): LiveData<T> {
        return finally
    }
}