package janmokry.scratchcard.feature.scratchcard.domain.repository.datastore

import janmokry.scratchcard.feature.scratchcard.domain.data.ScratchCardData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class ScratchCardDataStoreFake : ScratchCardDataStore {
    private val currentData = MutableStateFlow<ScratchCardData>(ScratchCardData.Unscratched)

    override fun observeScratchCard(): Flow<ScratchCardData> {
        return currentData
    }

    override suspend fun updateScratchCard(cardData: ScratchCardData) {
        currentData.value = cardData
    }
}
