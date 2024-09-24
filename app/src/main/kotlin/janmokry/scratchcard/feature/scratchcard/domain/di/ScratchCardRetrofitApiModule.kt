package janmokry.scratchcard.feature.scratchcard.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import janmokry.scratchcard.feature.scratchcard.domain.repository.api.ActivationCardApi
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ScratchCardRetrofitApiModule {
    @Singleton
    @Provides
    fun provideActivationCardApi(retrofit: Retrofit): ActivationCardApi = retrofit.create()
}
