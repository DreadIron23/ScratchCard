package janmokry.scratchcard.feature.scratchcard.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import janmokry.scratchcard.R
import janmokry.scratchcard.core.compose.component.PrimaryButton
import janmokry.scratchcard.core.compose.component.ScratchCard
import janmokry.scratchcard.core.compose.theme.ScratchCardTheme
import janmokry.scratchcard.feature.scratchcard.domain.data.ScratchCardData
import janmokry.scratchcard.feature.scratchcard.presentation.viewmodel.MainViewModel
import janmokry.scratchcard.feature.scratchcard.presentation.viewmodel.MainViewModel.UiState
import kotlinx.serialization.Serializable

@Serializable
object MainScreen

/**
 * Navigation entry point into [MainScreen].
 */
@Composable
internal fun MainScreenRoute(viewModel: MainViewModel = hiltViewModel()) {
    val uiState: UiState by viewModel.uiState.collectAsStateWithLifecycle()

    MainScreen(
        uiState = uiState,
        onScratchCardScreenButtonClick = viewModel::onScratchCardScreenButtonClick,
        onActivationScreenButtonClick = viewModel::onActivationScreenButtonClick,
    )
}

@Composable
private fun MainScreen(
    uiState: UiState,
    onScratchCardScreenButtonClick: () -> Unit,
    onActivationScreenButtonClick: () -> Unit,
) {
    Column(
        modifier =
            Modifier.fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
    ) {
        if (uiState is UiState.Loaded) {
            ScratchCard(cardCode = uiState.scratchCardData.code)
        }

        Spacer(Modifier.weight(1f))

        PrimaryButton(
            text = stringResource(R.string.main_screen_scratch_card_screen_button),
            onClick = onScratchCardScreenButtonClick,
        )

        PrimaryButton(
            text = stringResource(R.string.main_screen_activation_screen_button),
            onClick = onActivationScreenButtonClick,
        )
    }
}

private val ScratchCardData.code: String?
    get() =
        when (this) {
            ScratchCardData.Unscratched -> null
            is ScratchCardData.Scratched -> code
            is ScratchCardData.Activated -> code
        }

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun MainScreenScratchedPreview() {
    ScratchCardTheme {
        MainScreen(
            uiState = UiState.Loaded(ScratchCardData.Scratched("3afffb77-d956-4d04-ac06-14ef9710e997")),
            onScratchCardScreenButtonClick = {},
            onActivationScreenButtonClick = {},
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun MainScreenUnscratchedPreview() {
    ScratchCardTheme {
        MainScreen(
            uiState = UiState.Loaded(ScratchCardData.Unscratched),
            onScratchCardScreenButtonClick = {},
            onActivationScreenButtonClick = {},
        )
    }
}
