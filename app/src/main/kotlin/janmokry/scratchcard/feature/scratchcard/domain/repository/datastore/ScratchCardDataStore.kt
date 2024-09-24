package janmokry.scratchcard.feature.scratchcard.domain.repository.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import janmokry.scratchcard.feature.scratchcard.domain.data.ScratchCardData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Persistent Scratch Card storage. Single source of truth.
 */
interface ScratchCardDataStore {
    fun observeScratchCard(): Flow<ScratchCardData>

    suspend fun updateScratchCard(cardData: ScratchCardData)
}

@Singleton
class ScratchCardDataStoreImpl @Inject constructor(
    @ApplicationContext val context: Context,
) : ScratchCardDataStore {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "ScratchCardDataStore")

    private val typeKey = stringPreferencesKey("type")
    private val codeKey = stringPreferencesKey("code")

    private enum class CardState {
        UNSCRATCHED,
        SCRATCHED,
        ACTIVATED,
    }

    override fun observeScratchCard(): Flow<ScratchCardData> =
        context.dataStore.data.map { preferences ->
            when (CardState.valueOf(preferences[typeKey] ?: CardState.UNSCRATCHED.name)) {
                CardState.UNSCRATCHED -> ScratchCardData.Unscratched
                CardState.SCRATCHED -> ScratchCardData.Scratched(code = preferences[codeKey]!!)
                CardState.ACTIVATED -> ScratchCardData.Activated(code = preferences[codeKey]!!)
            }
        }

    override suspend fun updateScratchCard(cardData: ScratchCardData) {
        context.dataStore.edit { preferences ->
            when (cardData) {
                ScratchCardData.Unscratched -> {
                    preferences[typeKey] = CardState.UNSCRATCHED.name
                }
                is ScratchCardData.Scratched -> {
                    preferences[typeKey] = CardState.SCRATCHED.name
                    preferences[codeKey] = cardData.code
                }
                is ScratchCardData.Activated -> {
                    preferences[typeKey] = CardState.ACTIVATED.name
                    preferences[codeKey] = cardData.code
                }
            }
        }
    }
}
