    windowSize: WindowWidthSizeClass,
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
