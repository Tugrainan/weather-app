package com.kampplus.hava

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HavaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HavaUiState())

    val uiState: StateFlow<HavaUiState> =
        _uiState.asStateFlow()

    fun toggleFavorite(cityId: Long) {
        _uiState.update { currentState ->

            val updatedFavorites =
                if (cityId in currentState.favoriteCityIds) {
                    currentState.favoriteCityIds - cityId
                } else {
                    currentState.favoriteCityIds + cityId
                }

            currentState.copy(
                favoriteCityIds = updatedFavorites
            )
        }
    }
}
