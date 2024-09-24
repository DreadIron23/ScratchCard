package janmokry.scratchcard.core.network

import janmokry.scratchcard.BuildConfig
import javax.inject.Inject

/**
 * Provides base URL.
 */
class UrlApiProvider @Inject constructor() {
    fun provideBaseApiUrl(): String = BuildConfig.BASE_API_URL
}
