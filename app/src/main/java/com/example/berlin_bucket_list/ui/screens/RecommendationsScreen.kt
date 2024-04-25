package com.example.berlin_bucket_list.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.berlin_bucket_list.data.DataSource
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.ui.items.BerlinBucketListItem
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme

@Composable
fun RecommendationsScreen(
    recommendedPlaces: List<BerlinBucketListItem>,
    onSelectionChanged: (BerlinBucketListItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column {
        RecommendedPlacesItemList(
            modifier = modifier.fillMaxSize(),
            places = recommendedPlaces,
            onSelectionChanged = onSelectionChanged
        )
    }
}

@Composable
fun RecommendedPlacesItemList(
    modifier: Modifier = Modifier,
    onSelectionChanged: (BerlinBucketListItem) -> Unit,
    places: List<BerlinBucketListItem>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp, bottom = 24.dp, top = 24.dp),
        modifier = modifier
    ) {
        items(places) { place ->
            BerlinBucketListItem(
                item = place,
                isHomeScreen = false,
                onItemClicked = { onSelectionChanged(place) }
            )
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
            onSelectionChanged = {}
        )
    }
}
