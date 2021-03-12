package com.bintang.mvvmdaggercrud.dagger.component

import android.app.Application
import com.bintang.mvvmdaggercrud.dagger.AppFile
import com.bintang.mvvmdaggercrud.dagger.builder.ActivityBuilders
import com.bintang.mvvmdaggercrud.dagger.module.ModuleApp
import com.bintang.mvvmdaggercrud.dagger.viewmodel.ViewModelFactoryModule
import com.bintang.mvvmdaggercrud.network.ConfigNetwork
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ViewModelFactoryModule::class,
            ConfigNetwork::class,
            ModuleApp::class,
            ActivityBuilders::class
        ]
)
interface ComponentApi : AndroidInjector<AppFile> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ComponentApi
    }
}