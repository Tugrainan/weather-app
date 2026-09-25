package com.kampplus.hava

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kampplus.hava.core.ui.theme.HavaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HavaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    ContentCard(
        title = "Hava Durumu",
        description = "Şehirlerin hava durumunu keşfet.",
        modifier = modifier
    )
}
@Composable
fun ContentCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title
        )

        Text(
            text = description
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ContentCardShortPreview() {
    HavaTheme {
        ContentCard(
            title = "Hava Durumu",
            description = "Şehirlerin hava durumunu keşfet."
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun ContentCardLongPreview() {
    HavaTheme {
        ContentCard(
            title = "Şehrinizin Hava Durumu",
            description = "Seçtiğiniz şehirlerin güncel hava durumunu inceleyebilir ve hava koşulları hakkında ayrıntılı bilgi görüntüleyebilirsiniz."
        )
    }
}
