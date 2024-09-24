package janmokry.scratchcard.feature.scratchcard.domain.repository.api

import janmokry.scratchcard.feature.scratchcard.domain.repository.model.dto.AndroidVersionDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ActivationCardApi {
    @GET("version")
    suspend fun getAndroidVersion(
        @Query("code") query: String,
    ): Result<AndroidVersionDto>
}
