package janmokry.scratchcard.feature.scratchcard.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import janmokry.scratchcard.feature.scratchcard.domain.repository.datastore.ScratchCardDataStore
import janmokry.scratchcard.feature.scratchcard.domain.repository.datastore.ScratchCardDataStoreImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ScratchCardDomainModule {
    @Singleton
    @Binds
    fun bindScratchCardDataStore(impl: ScratchCardDataStoreImpl): ScratchCardDataStore
}
