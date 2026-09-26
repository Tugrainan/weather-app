package com.kampplus.hava.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kampplus.hava.feature.weather.presentation.detail.ForecastDetailScreen
import com.kampplus.hava.feature.weather.presentation.list.CityListRoute
import com.kampplus.hava.feature.weather.presentation.detail.InvalidCityScreen

@Composable
fun HavaNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "city_list",
        modifier = modifier
    ) {

        composable("city_list") {
            CityListRoute(
                onCityClick = { cityId ->
                    navController.navigate("forecast_detail/$cityId")
                }
            )
        }

        composable(
            route = "forecast_detail/{cityId}",
            arguments = listOf(
                navArgument("cityId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val cityId = backStackEntry.arguments
                ?.getString("cityId")
                ?.toLongOrNull()

            if (cityId != null && cityId > 0) {
                ForecastDetailScreen(
                    cityId = cityId,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            } else {
                InvalidCityScreen(
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

