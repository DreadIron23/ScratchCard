package janmokry.scratchcard.core.compose.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import janmokry.scratchcard.R
import janmokry.scratchcard.core.compose.theme.ScratchCardTheme

@Composable
fun ScratchCard(
    cardCode: String?,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier) {
        val configuration = LocalConfiguration.current
        Box(
            modifier =
            Modifier
                .aspectRatio(
                    ratio = 2f,
                    matchHeightConstraintsFirst = configuration.orientation != Configuration.ORIENTATION_PORTRAIT,
                )
                .padding(24.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = cardCode ?: stringResource(R.string.main_screen_card_unscratched),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@Preview
@Composable
private fun ScratchCardUnscratchedPreview() {
    ScratchCardTheme {
        ScratchCard(cardCode = null)
    }
}

@Preview
@Composable
private fun ScratchCardScratchedPreview() {
    ScratchCardTheme {
        ScratchCard(cardCode = "3afffb77-d956-4d04-ac06-14ef9710e997")
    }
}
