package janmokry.scratchcard.core.compose.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import janmokry.scratchcard.core.compose.preview.PreviewDark
import janmokry.scratchcard.core.compose.theme.ScratchCardTheme

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    inProgress: Boolean = false,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = !inProgress && enabled,
    ) {
        if (inProgress) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    strokeWidth = 2.5.dp,
                    modifier = Modifier.size(20.dp).padding(2.dp),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = text,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                )
            }
        } else {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}

@Preview("Default", "PrimaryButton")
@Preview("Large font", "PrimaryButton", fontScale = 2f)
@PreviewDark
@Composable
private fun PrimaryButtonPreview() {
    ScratchCardTheme {
        PrimaryButton(
            text = "Primary Button",
            onClick = {},
        )
    }
}

@Preview("Disabled", "PrimaryButton", showBackground = true)
@PreviewDark
@Composable
private fun PrimaryButtonDisabledPreview() {
    ScratchCardTheme {
        PrimaryButton(
            text = "Disabled Primary Button",
            enabled = false,
            onClick = {},
        )
    }
}

@Preview("In progress", "PrimaryButton", showBackground = true)
@PreviewDark
@Composable
private fun PrimaryButtonInProgressPreview() {
    ScratchCardTheme {
        PrimaryButton(
            text = "In Progress Primary Button",
            inProgress = true,
            onClick = {},
        )
    }
}
