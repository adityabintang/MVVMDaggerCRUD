package com.bintang.mvvmdaggercrud.model



import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseTambah(

    @field:SerializedName("data")
    val data: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("isSuccess")
    val isSuccess: Boolean? = null,

    @field:SerializedName("status")
    val status: Int? = null
) : Parcelable
