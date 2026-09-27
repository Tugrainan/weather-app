package com.kampplus.hava.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kampplus.hava.feature.weather.domain.model.City
import com.kampplus.hava.feature.weather.presentation.detail.ForecastDetailRoute
import com.kampplus.hava.feature.weather.presentation.list.CityListRoute

@Composable
fun HavaNavHost(
    favoriteCityIds: Set<Long>,
    onFavoriteToggle: (Long) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val openForecast: (City) -> Unit = { city -> navController.navigate(city.toDestination()) }
    NavHost(
        navController = navController,
        startDestination = ListDestination,
        modifier = modifier
    ) {
        composable<ListDestination> {
            CityListRoute(
                onCityClick = openForecast,
                favoriteCityIds = favoriteCityIds,
                onFavoriteToggle = onFavoriteToggle
            )
        }
        composable<ForecastDestination> {
            ForecastDetailRoute(
                favoriteCityIds = favoriteCityIds,
                onFavoriteToggle = onFavoriteToggle,
                onBack = navController::navigateUp
            )
        }
    }
}

private fun City.toDestination() = ForecastDestination(
    cityId = id,
    name = name,
    region = region,
    country = country,
    latitude = coordinates.latitude,
    longitude = coordinates.longitude
)
