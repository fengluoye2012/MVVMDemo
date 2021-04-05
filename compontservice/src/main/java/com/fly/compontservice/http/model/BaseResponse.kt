package com.fly.compontservice.http.model

import java.io.Serializable

//网络请求返回值结构
data class BaseResponse<T>(var code: Int, var msg: String, var data: T) : Serializable