package com.example.berlin_bucket_list.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.berlin_bucket_list.R
import com.example.berlin_bucket_list.data.DataSource
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.model.CategoryType
import com.example.berlin_bucket_list.ui.items.RecommendedPlaceDetails
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme

@Composable
fun DetailsScreen(
    item: BerlinBucketListItem,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    RecommendedPlaceDetails(
        windowSize = windowSize,
        imageId = item.imageId,
        placeDescription = item.placeDescription ?: "",
        extraInfo = item.extraInfo ?: "",
        address = item.address ?: -1,
        credits = item.credits ?: -1,
        modifier = modifier.padding(top = 18.dp)
    )
}

@Preview
@Composable
fun DetailsScreenPreview() {
    BerlinBucketListTheme {
        DetailsScreen(
            item = BerlinBucketListItem(
                imageId = R.drawable.barcomis_2,
                name = R.string.cafe_1,
                address = R.string.cafe_address_1,
                credits = R.string.credits_cafes_general,
                placeDescription = DataSource.cafes[0].placeDescription,
                extraInfo = DataSource.cafes[0].extraInfo,
                placeDetails = null,
                categoryType = CategoryType.Cafes
            ),
            windowSize = WindowWidthSizeClass.Expanded,
        )
    }
}
