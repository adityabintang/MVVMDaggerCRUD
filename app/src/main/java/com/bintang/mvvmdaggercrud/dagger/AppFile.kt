package com.bintang.mvvmdaggercrud.dagger


import com.bintang.mvvmdaggercrud.dagger.component.DaggerComponentApi
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AppFile : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerComponentApi.builder().application(this).build()
    }

}