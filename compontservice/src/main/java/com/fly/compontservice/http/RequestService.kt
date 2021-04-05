package com.fly.compontservice.http

import com.fly.compontservice.http.model.BaseResponse
import com.fly.compontservice.http.model.LoginModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RequestService {

    @POST("user/login")
    @FormUrlEncoded
    suspend fun login(
        @Field("userName") userName: String,
        @Field("passWord") passWord: String
    ): BaseResponse<LoginModel>
}