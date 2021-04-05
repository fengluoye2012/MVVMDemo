package com.fly.compontservice.http.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ErrorModel(var code: Int, var msg: String) : Parcelable