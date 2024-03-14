package com.example.berlin_bucket_list.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.berlin_bucket_list.data.DataSource
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme

@Composable
fun RecommendationsScreen(
    recommendedPlaces: List<BerlinBucketListItem>,
    modifier: Modifier = Modifier,
) {
    Column {
        RecommendedPlacesItemList(
            modifier = modifier.fillMaxSize(),
            places = recommendedPlaces
        )
    }
}

@Composable
fun RecommendedPlacesItemList(
    modifier: Modifier = Modifier,
    places: List<BerlinBucketListItem>
) {
    LazyColumn(modifier = modifier) {
        items(places) { place ->
            BerlinBucketListItem(
                item = place,
                onItemClicked = { /*TODO*/ })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlacesScreenPreview() {
    BerlinBucketListTheme {
        RecommendationsScreen(
            modifier = Modifier,
            recommendedPlaces = DataSource.parks,
        )
    }
}
