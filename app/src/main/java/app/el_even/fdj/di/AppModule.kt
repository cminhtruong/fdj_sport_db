package app.el_even.fdj.di

import app.el_even.fdj.common.Constant
import app.el_even.fdj.data.remote.api.SportDBApi
import app.el_even.fdj.data.repository.FDJRepositoryImpl
import app.el_even.fdj.domain.repository.FDJRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSportDBApi(): SportDBApi = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            )
        )
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(SportDBApi::class.java)

    @Provides
    @Singleton
    fun provideFDJRepository(api: SportDBApi): FDJRepository = FDJRepositoryImpl(api)
}