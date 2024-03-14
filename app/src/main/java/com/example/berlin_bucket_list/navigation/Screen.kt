package com.example.berlin_bucket_list.navigation

sealed class Screen(val route: String) {
    data object HomeScreen : Screen(route = "Home")
    data object RecommendationsScreen : Screen("Recommendations")
    data object DetailsScreen : Screen(route = "Details")
}
