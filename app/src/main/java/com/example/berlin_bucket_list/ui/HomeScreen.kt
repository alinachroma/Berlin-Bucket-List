package com.example.berlin_bucket_list.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
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

    Box {
        Image(
            painter = painterResource(id = R.drawable.background_1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
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
                        },
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
}

// The ClippedShadow and ShadowBox Composables fix the
// material shadow glitch on transparent/translucent Composables.
// Author: zed-alpha. Repo: https://gist.github.com/zed-alpha/3dc931720292c1f3ff31fa6a130f52cd
@Composable
fun ClippedShadow(elevation: Dp, shape: Shape, modifier: Modifier = Modifier) {
    Layout(
        modifier
            .drawWithCache {
                val path = androidx.compose.ui.graphics.Path()
                var lastSize: Size? = null

                fun updatePathIfNeeded() {
                    if (size != lastSize) {
                        path.reset()
                        path.addOutline(
                            shape.createOutline(size, layoutDirection, this)
                        )
                        lastSize = size
                    }
                }

                onDrawWithContent {
                    updatePathIfNeeded()
                    clipPath(path, ClipOp.Difference) {
                        this@onDrawWithContent.drawContent()
                    }
                }
            }
            .shadow(elevation, shape)
    ) { _, constraints ->
        layout(constraints.minWidth, constraints.minHeight) {}
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun ShadowBox(
    elevation: Dp,
    shape: Shape,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        {
            ClippedShadow(elevation, shape, modifier)
            CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                content()
            }
        },
        modifier
    ) { measurable, constraints ->
        require(measurable.size == 2)

        val shadow = measurable[0]
        val target = measurable[1]

        val targetPlaceable = target.measure(constraints)
        val width = targetPlaceable.width
        val height = targetPlaceable.height

        val shadowPlaceable = shadow.measure(Constraints.fixed(width, height))

        layout(width, height) {
            shadowPlaceable.place(0, 0)
            targetPlaceable.place(0, 0)
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
    ShadowBox(
        elevation = 10.dp,
        shape = Shapes.small,
        modifier = modifier
    ) {
        Card(
            onClick = onItemClicked,
            shape = Shapes.small,
            colors = CardDefaults.elevatedCardColors(White.copy(alpha = 0.3f)),
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
                Text(
                    text = stringResource(id = item.name).uppercase(),
                    style = MaterialTheme.typography.displayMedium,
                    color = White
                )

            }
        }
    }
}

@Composable
fun HomeScreen(
    categories: List<BerlinBucketListItem>,
    onSelectionChanged: (BerlinBucketListItem) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier.padding(
            start = 24.dp,
            end = 24.dp
        )
    ) {
        items(categories) { category ->
            BerlinBucketListItem(
                item = category,
                onItemClicked = { onSelectionChanged(category) },
                modifier = Modifier
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerlinBucketListAppBar(
    screenTitle: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(text = screenTitle)
            /*Image(
                painter = painterResource(id = R.drawable.appbar_black),
                contentDescription = null
            )*/
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun BerlinBucketListAppBarPreview() {
    BerlinBucketListTheme {
        BerlinBucketListAppBar(
            canNavigateBack = false,
            screenTitle = Screen.HomeScreen.route
        )
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

