package janmokry.scratchcard.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import janmokry.scratchcard.core.compose.theme.ScratchCardTheme
import janmokry.scratchcard.feature.scratchcard.presentation.view.MainScreenRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScratchCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // todo nav graph
                    MainScreenRoute()
                }
            }
        }
    }
}
