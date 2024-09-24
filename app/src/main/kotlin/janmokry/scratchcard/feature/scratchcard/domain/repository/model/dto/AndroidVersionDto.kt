package janmokry.scratchcard.feature.scratchcard.domain.repository.model.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AndroidVersionDto(
    val android: Int,
)
