package com.example.berlin_bucket_list.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.berlin_bucket_list.R
import com.example.berlin_bucket_list.data.DataSource
import com.example.berlin_bucket_list.data.DataSource.emptyItem
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.navigation.Screen
import com.example.berlin_bucket_list.ui.BerlinBucketListViewModel
import com.example.berlin_bucket_list.ui.items.AppLogoBig
import com.example.berlin_bucket_list.ui.items.BerlinBucketListAppBar
import com.example.berlin_bucket_list.ui.items.BerlinBucketListItem
import com.example.berlin_bucket_list.ui.items.RecommendedPlaceListAndDetails
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme
import com.example.berlin_bucket_list.ui.utils.BerlinBucketListContentType

@Composable
fun BerlinBucketListApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    val viewModel: BerlinBucketListViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsState().value
    val context = LocalContext.current

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: Screen.HomeScreen.route

    val currentScreen = Screen::class.nestedClasses
        .map { it.objectInstance as Screen }
        .find { it.route == currentRoute }

    val topBarTitle = when (currentScreen) {
        is Screen.HomeScreen -> context.getString(R.string.app_name)
        is Screen.RecommendationsScreen -> uiState.currentCategory?.title?.let {
            context.getString(it)
        }

        is Screen.DetailsScreen -> uiState.recommendedPlace?.name?.let {
            context.getString(it)
        }

        else -> ""
    }

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            BerlinBucketListContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            BerlinBucketListContentType.LIST_AND_DETAIL
        }

        else -> BerlinBucketListContentType.LIST_ONLY
    }
    Box {
        Image(
            painter = painterResource(id = R.drawable.background_1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.matchParentSize()
        )
        if (currentRoute == Screen.HomeScreen.route) {
            AppLogoBig()
        }
        Scaffold(
            containerColor = Transparent,
            topBar = {
                BerlinBucketListAppBar(
                    screenTitle = topBarTitle ?: "",
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
                )
            },
            modifier = Modifier
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.HomeScreen.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = Screen.HomeScreen.route) {
                    HomeScreen(
                        categories = DataSource.categories,
                        onSelectionChanged = {
                            viewModel.updateCurrentCategory(
                                clickedCategory = it.categoryType
                            )
                            navController.navigate(Screen.RecommendationsScreen.route)
                        },
                        isHomeScreen = true,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
                composable(route = Screen.RecommendationsScreen.route) {
                    if (contentType == BerlinBucketListContentType.LIST_ONLY) {
                        RecommendationsScreen(
                            recommendedPlaces = uiState.placesToShow,
                            onSelectionChanged = {
                                viewModel.updateRecommendedPlace(recommendedPlace = it)
                                navController.navigate(route = "Details/${it}")
                            },
                        )
                    } else {
                        RecommendedPlaceListAndDetails(
                            placesToShow = uiState.placesToShow,
                            onSelectionChanged = {
                                viewModel.updateRecommendedPlace(recommendedPlace = it)
                            },
                            imageId = uiState.recommendedPlace?.imageId
                                ?: R.drawable.appbar_black,
                            placeDescription = uiState.recommendedPlace?.placeDescription ?: "",
                            extraInfo = uiState.recommendedPlace?.extraInfo ?: "",
                            address = uiState.recommendedPlace?.address ?: -1,
                            credits = uiState.recommendedPlace?.credits ?: -1,
                            modifier = Modifier,
                            windowSize = windowSize
                        )
                    }
                }
                composable(route = Screen.DetailsScreen.route) {
                    if (contentType == BerlinBucketListContentType.LIST_ONLY) {
                        DetailsScreen(
                            windowSize = windowSize,
                            item = uiState.recommendedPlace ?: emptyItem
                        )
                    } else {
                        RecommendedPlaceListAndDetails(
                            placesToShow = uiState.placesToShow,
                            onSelectionChanged = {
                                viewModel.updateRecommendedPlace(recommendedPlace = it)
                            },
                            imageId = uiState.recommendedPlace?.imageId
                                ?: R.drawable.appbar_black,
                            placeDescription = uiState.recommendedPlace?.placeDescription ?: "",
                            extraInfo = uiState.recommendedPlace?.extraInfo ?: "",
                            address = uiState.recommendedPlace?.address ?: -1,
                            credits = uiState.recommendedPlace?.credits ?: -1,
                            modifier = Modifier,
                            windowSize = windowSize
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    categories: List<BerlinBucketListItem>,
    onSelectionChanged: (BerlinBucketListItem) -> Unit,
    isHomeScreen: Boolean,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(all = 24.dp),
        modifier = modifier,
    ) {
        items(categories) { category ->
            BerlinBucketListItem(
                item = category,
                onItemClicked = { onSelectionChanged(category) },
                isHomeScreen = isHomeScreen,
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    BerlinBucketListTheme {
        HomeScreen(
            categories = DataSource.categories,
            isHomeScreen = true,
            onSelectionChanged = {}
        )
    }
}

