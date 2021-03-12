package com.bintang.mvvmdaggercrud.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bintang.mvvmdaggercrud.model.ResponseTambah
import com.bintang.mvvmdaggercrud.repository.RepositoryApp

class ViewModel(val repo: RepositoryApp) : ViewModel() {
    val isSuccess = MutableLiveData<ResponseTambah>()
    val isError = MutableLiveData<Throwable>()

    fun tambahData(
        nama: String,
        alamat: String,
        jenis_kelamin: String,
        hobi: String,
        agama: String
    ){
        repo.tambah(nama, alamat, jenis_kelamin, hobi, agama, {
            isSuccess.value = it
        }, {
            isError.value = it
        })
    }

    fun isSuccess(): LiveData<ResponseTambah>{
        return isSuccess
    }
    fun isError(): LiveData<Throwable> {
        return isError
    }
}