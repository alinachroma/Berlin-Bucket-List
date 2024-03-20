package com.example.berlin_bucket_list.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.berlin_bucket_list.R
import com.example.berlin_bucket_list.data.DataSource
import com.example.berlin_bucket_list.data.DataSource.emptyItem
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.model.CategoryType
import com.example.berlin_bucket_list.navigation.Screen
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme
import com.example.berlin_bucket_list.ui.theme.Shapes

@Composable
fun BerlinBucketListApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val viewModel: BerlinBucketListViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsState().value

    Scaffold(
        topBar = { BerlinBucketListAppBar() }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.HomeScreen.route,
            modifier = modifier.padding(innerPadding)
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
                    modifier = Modifier.padding(innerPadding),
                )
            }
            composable(route = Screen.RecommendationsScreen.route) {
                RecommendationsScreen(
                    recommendedPlaces = uiState.placesToShow,
                    onSelectionChanged = {
                        viewModel.updateRecommendedPlace(recommendedPlace = it)
                        navController.navigate(route = "Details/${it}")
                    }
                )
            }
            composable(route = Screen.DetailsScreen.route) {
                DetailsScreen(
                    item = uiState.recommendedPlace ?: emptyItem
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerlinBucketListItem(
    item: BerlinBucketListItem,
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        onClick = onItemClicked,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier.size(dimensionResource(id = R.dimen.icon_height))
            ) {
                Image(
                    painter = painterResource(id = item.imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier.clip(Shapes.small)
                )
            }
            Text(text = stringResource(id = item.name))
        }
    }
}

@Composable
fun HomeScreen(
    categories: List<BerlinBucketListItem>,
    onSelectionChanged: (BerlinBucketListItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(categories) { category ->
            BerlinBucketListItem(
                item = category,
                onItemClicked = { onSelectionChanged(category) },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerlinBucketListAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.appbar_black),
                contentDescription = null
            )
        },
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun BerlinBucketListAppBarPreview() {
    BerlinBucketListTheme {
        BerlinBucketListAppBar()
    }
}

@Preview(showBackground = true)
@Composable
fun BerlinBucketListItemPreview() {
    BerlinBucketListTheme {
        BerlinBucketListItem(
            item = BerlinBucketListItem(
                imageId = R.drawable.barcomis_1,
                name = R.string.cafe_1,
                address = null,
                credits = null,
                placeDescription = null,
                placeDetails = null,
                categoryType = CategoryType.Cafes
            ),
            onItemClicked = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    BerlinBucketListTheme {
        HomeScreen(
            categories = DataSource.categories,
            onSelectionChanged = {}
        )
    }
}

