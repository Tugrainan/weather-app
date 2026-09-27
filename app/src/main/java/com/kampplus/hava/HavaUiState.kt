package com.kampplus.hava

data class HavaUiState(
    val favoriteCityIds: Set<Long> = emptySet()
) {
    val favoriteCount: Int
        get() = favoriteCityIds.size

    fun isFavorite(cityId: Long): Boolean {
        return cityId in favoriteCityIds
    }
}
