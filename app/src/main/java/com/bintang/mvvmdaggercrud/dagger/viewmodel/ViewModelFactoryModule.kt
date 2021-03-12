package com.bintang.mvvmdaggercrud.dagger.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class ViewModelFactoryModule {

    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory : ViewModelProvideFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ViewModel::class)
    abstract fun bindViewModel(viewModel: ViewModel): ViewModel
}