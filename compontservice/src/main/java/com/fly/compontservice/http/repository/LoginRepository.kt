package com.fly.compontservice.http.repository

import com.fly.compontservice.http.MainRetrofitClient
import com.fly.compontservice.http.base.BaseRepository
import com.fly.compontservice.http.model.BaseResponse
import com.fly.compontservice.http.model.LoginModel

class LoginRepository : BaseRepository<LoginModel>() {

    suspend fun loginData(userName: String, passWord: String): BaseResponse<LoginModel> = request {
        MainRetrofitClient.reqApi.login(userName, passWord)
    }
}