package com.example.berlin_bucket_list.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme
import com.example.berlin_bucket_list.ui.theme.Shapes
import com.example.berlin_bucket_list.R
import com.example.berlin_bucket_list.model.CategoryType

@Composable
fun DetailsScreen(
    item: BerlinBucketListItem,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints {
        val rectangleWidth = this.maxWidth
        val rectangleHeight = this.maxHeight
        Column(
            verticalArrangement = Arrangement.spacedBy((-100).dp)
        ) {
            ElevatedCard(
                modifier = modifier
                    .size(rectangleWidth, rectangleHeight)
                    .weight(1f)
                    .clip(Shapes.medium),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
            ) {
                Image(
                    painter = painterResource(id = item.imageId),
                    contentDescription = null
                )

            }
            ElevatedCard(
                modifier = Modifier
                    .size(rectangleWidth, rectangleHeight)
                    .weight(1f)
                    .clip(Shapes.medium),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray,
                )
            ) {
                Text(text = item.placeDescription ?: "")
                Text(text = stringResource(id = R.string.where))
                ElevatedCard {
                    Text(text = stringResource(id = item.address ?: -1))
                }
                Row {
                    Text(text = stringResource(id = R.string.text_and_photo))
                    Text(text = stringResource(id = item.credits ?: -1))
                }
            }
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    BerlinBucketListTheme {
        DetailsScreen(
            item = BerlinBucketListItem(
                imageId = R.drawable.barcomis_1,
                name = R.string.cafe_1,
                address = R.string.cafe_address_1,
                credits = R.string.credits_cafes_general,
                placeDescription = "“Bonanza coffee doesn’t have to taste that way. But it does.\n" +
                        "It’s not your typical. It's unnecessarily good.\n" +
                        "Maybe that's because we're unnecessarily driven.\n" +
                        "Unnecessarily curious. Unnecessarily obsessed.”",
                placeDetails = null,
                categoryType = CategoryType.Cafes
            )
        )
    }
}