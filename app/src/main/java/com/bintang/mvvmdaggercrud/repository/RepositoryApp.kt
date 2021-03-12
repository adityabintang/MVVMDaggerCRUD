package com.bintang.mvvmdaggercrud.repository

import com.bintang.mvvmdaggercrud.model.ResponseTambah
import com.bintang.mvvmdaggercrud.network.RestApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoryApp(val restApi: RestApi) {
    fun tambah(
            nama: String,
            alamat: String,
            jenis_kelamin: String,
            hobi: String,
            agama: String,
            responseSuccess: (ResponseTambah)-> Unit,
            responseError: (Throwable)-> Unit
    ) {
        restApi.addUser(nama, alamat, jenis_kelamin, hobi, agama)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responseSuccess(it)
                }, {
                    responseError(it)
                })

    }
}