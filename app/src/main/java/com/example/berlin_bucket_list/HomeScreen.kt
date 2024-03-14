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
            composable(Screen.RecommendationsScreen.route) {
                RecommendationsScreen(
                    recommendedPlaces = uiState.placesToShow,
                )
            }
            composable(Screen.DetailsScreen.route) {
                DetailsScreen()
            }
