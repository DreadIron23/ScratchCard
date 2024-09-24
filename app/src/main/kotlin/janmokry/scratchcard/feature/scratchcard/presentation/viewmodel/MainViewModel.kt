package janmokry.scratchcard.feature.scratchcard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import janmokry.scratchcard.feature.scratchcard.domain.data.ScratchCardData
import janmokry.scratchcard.feature.scratchcard.domain.usecase.ObserveScratchCardUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    observeScratchCardUseCase: ObserveScratchCardUseCase,
) : ViewModel() {
    sealed interface UiState {
        data object Loading : UiState

        data class Loaded(val scratchCardData: ScratchCardData) : UiState
    }

    val uiState: StateFlow<UiState> =
        observeScratchCardUseCase()
            .map { UiState.Loaded(it) }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = UiState.Loading,
            )

    fun onScratchCardScreenButtonClick() {
        // todo navigation
    }

    fun onActivationScreenButtonClick() {
        // todo navigation
    }
}
