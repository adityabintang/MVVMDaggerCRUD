package com.bintang.mvvmdaggercrud.dagger.builder

import com.bintang.mvvmdaggercrud.dagger.module.ModuleApp
import com.bintang.mvvmdaggercrud.dagger.viewmodel.ViewModelFactoryModule
import com.bintang.mvvmdaggercrud.repository.RepositoryApp
import com.bintang.mvvmdaggercrud.scope.Presentation
import com.bintang.mvvmdaggercrud.view.MainActivity
import com.bintang.mvvmdaggercrud.view.TampilActivity
import com.bintang.mvvmdaggercrud.viewmodel.ViewModel
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilders {

    @Presentation
    @ContributesAndroidInjector(
        modules = [
            ModuleApp::class
        ]
    )
    abstract fun contributeRepository(): RepositoryApp

    @Presentation
    @ContributesAndroidInjector(
        modules = [
            ModuleApp::class
        ]
    )
    abstract fun contributeViewModule(): ViewModel
//
//    @Presentation
//    @ContributesAndroidInjector(
//        modules = [
//            ViewModelFactoryModule::class
//        ]
//    )
//    abstract fun contributeTampilActivity(): TampilActivity

    @Presentation
    @ContributesAndroidInjector(
        modules = [
            ViewModelFactoryModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}