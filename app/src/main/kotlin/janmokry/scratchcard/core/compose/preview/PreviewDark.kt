package janmokry.scratchcard.core.compose.preview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * A annotation for displaying a @Composable method using dark theme.
 */
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION,
)
@Preview(
    name = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
)
annotation class PreviewDark
