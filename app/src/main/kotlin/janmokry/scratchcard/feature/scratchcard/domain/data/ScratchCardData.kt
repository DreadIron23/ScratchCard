package janmokry.scratchcard.feature.scratchcard.domain.data

sealed interface ScratchCardData {
    data object Unscratched : ScratchCardData

    data class Scratched(
        val code: String,
    ) : ScratchCardData

    data class Activated(
        val code: String,
    ) : ScratchCardData
}
