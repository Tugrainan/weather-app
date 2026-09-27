package com.kampplus.hava

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kampplus.hava.core.navigation.HavaNavHost

@Composable
fun HavaApp(
    modifier: Modifier = Modifier,
    viewModel: HavaViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HavaNavHost(
        favoriteCityIds = uiState.favoriteCityIds,
        onFavoriteToggle = viewModel::toggleFavorite,
        modifier = modifier
    )
}
