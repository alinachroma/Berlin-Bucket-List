package com.example.berlin_bucket_list.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.berlin_bucket_list.R
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.model.CategoryType
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme
import com.example.berlin_bucket_list.ui.theme.DarkGreenCard
import com.example.berlin_bucket_list.ui.theme.DarkYellowCard
import com.example.berlin_bucket_list.ui.theme.GreenCard
import com.example.berlin_bucket_list.ui.theme.Shapes

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
            val colorStops = arrayOf(
                0.0f to DarkGreenCard,
                0.5f to GreenCard,
                1f to DarkYellowCard
            )
            ElevatedCard(
                modifier = modifier
                    .size(rectangleWidth, rectangleHeight)
                    .weight(1f)
                    .clip(Shapes.medium),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = item.imageId),
                        contentScale = ContentScale.FillHeight,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            ElevatedCard(
                modifier = Modifier
                    .weight(1f)
                    .clip(Shapes.medium)
                    .background(Brush.verticalGradient(colorStops = colorStops)),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 20.dp)
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
            ),
        )
    }
}
