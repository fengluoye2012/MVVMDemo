package com.fly.compontservice.http.base

import com.fly.compontservice.http.model.BaseResponse
import com.fly.compontservice.http.model.LoginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


//Repository 用在VM和网络请求/数据库之间
open class BaseRepository<T> {
    suspend fun <T : Any> request(call: suspend () -> BaseResponse<T>): BaseResponse<T> {
        val response = withContext(Dispatchers.IO) {
            call.invoke()
        }

        return response.apply {

            //这儿可以对返回结果errorCode做一些特殊处理，比如上传参数错误等，可以通过抛出异常的方式实现
            //例：当上传参数错误时，后台返回errorCode 为 1001，下面代码实现,再到baseActivity通过观察error来处理
        }
    }
}