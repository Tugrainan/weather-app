package com.kampplus.hava.feature.weather.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ForecastDetailScreen(
    cityId: Long,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Tahmin Detayı"
        )

        Text(
            text = "Seçilen şehir ID: $cityId"
        )

        Button(
            onClick = onBack
        ) {
            Text("Geri")
        }
    }
}
@Composable
fun InvalidCityScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Geçersiz şehir bilgisi."
        )

        Button(
            onClick = onBack
        ) {
            Text("Şehirlere Dön")
        }
    }
}
