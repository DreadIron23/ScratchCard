package janmokry.scratchcard.feature.scratchcard.domain.usecase

import janmokry.scratchcard.feature.scratchcard.domain.data.ScratchCardData
import janmokry.scratchcard.feature.scratchcard.domain.repository.datastore.ScratchCardDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveScratchCardUseCase @Inject constructor(
    private val scratchCardDataStore: ScratchCardDataStore,
) {
    operator fun invoke(): Flow<ScratchCardData> = scratchCardDataStore.observeScratchCard()
}
