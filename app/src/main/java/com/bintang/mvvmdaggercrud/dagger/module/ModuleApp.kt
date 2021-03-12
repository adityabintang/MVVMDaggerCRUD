package com.bintang.mvvmdaggercrud.dagger.module

import com.bintang.mvvmdaggercrud.network.RestApi
import com.bintang.mvvmdaggercrud.repository.RepositoryApp
import com.bintang.mvvmdaggercrud.viewmodel.ViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class ModuleApp {
    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesConfigNetwork(retrofit: Retrofit):RestApi =
            retrofit.create(RestApi::class.java)

        @JvmStatic
        @Provides
        fun provideRepository(restApi: RestApi): RepositoryApp = RepositoryApp(restApi)

        @JvmStatic
        @Provides
        fun provideViewModel(repo: RepositoryApp): ViewModel = ViewModel(repo)
    }
}