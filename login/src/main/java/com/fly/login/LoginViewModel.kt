package com.fly.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fly.compontservice.http.base.BaseViewModel
import com.fly.compontservice.http.model.BaseResponse
import com.fly.compontservice.http.model.LoginModel
import com.fly.compontservice.http.repository.LoginRepository

class LoginViewModel : BaseViewModel<LoginModel>() {

    private var data: MutableLiveData<BaseResponse<LoginModel>> = MutableLiveData()


    private val repository = LoginRepository()

    fun getLogin(): LiveData<BaseResponse<LoginModel>> {
        return data
    }

    fun loginData(userName: String, passWord: String) = launchUI {
        val loginData = repository.loginData(userName, passWord)
        data.postValue(loginData)
    }
}