package com.bintang.mvvmdaggercrud.network

import com.bintang.mvvmdaggercrud.model.ResponseTambah
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RestApi {
    @FormUrlEncoded
    @POST("tambahUser")
    fun addUser(
        @Field("nama") nama: String,
        @Field("alamat") alamat: String,
        @Field("jenis_kelamin") jenis_kelamin: String,
        @Field("hobi") hobi: String,
        @Field("agama") agama: String
    ):Single<ResponseTambah>
}