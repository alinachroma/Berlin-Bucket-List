package com.example.berlin_bucket_list.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.berlin_bucket_list.R
import com.example.berlin_bucket_list.data.DataSource
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.model.CategoryType
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme
import com.example.berlin_bucket_list.ui.theme.DarkGreenCard
import com.example.berlin_bucket_list.ui.theme.DarkYellowCard
import com.example.berlin_bucket_list.ui.theme.GreenCard
import com.example.berlin_bucket_list.ui.theme.Shapes
import com.example.berlin_bucket_list.ui.utils.ShadowBox

@Composable
fun DetailsScreen(
    item: BerlinBucketListItem,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints {
        val rectangleWidth = this.maxWidth
        val rectangleHeight = this.maxHeight
        Column(
            verticalArrangement = Arrangement.spacedBy((-100).dp),
            modifier = modifier.padding(top = 18.dp)
        ) {
            val colorStops = arrayOf(
                0.0f to DarkGreenCard,
                0.5f to GreenCard,
                1f to DarkYellowCard
            )
            Card(
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
                modifier = modifier
                    .clip(Shapes.medium)
                    .shadow(elevation = 3.dp, spotColor = Black)
                    .size(rectangleWidth, rectangleHeight)
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(id = item.imageId),
                    contentScale = ContentScale.FillHeight,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            ShadowBox(
                elevation = 10.dp,
                shape = Shapes.medium,
                modifier = Modifier.weight(1.2f)
            ) {
                Card(
                    modifier = Modifier
                        .shadow(elevation = 16.dp, ambientColor = White, spotColor = White)
                        .clip(RoundedCornerShape(topStartPercent = 10, topEndPercent = 10))
                        .background(Brush.verticalGradient(colorStops = colorStops)),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 24.dp, end = 24.dp, top = 36.dp, bottom = 24.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = item.placeDescription ?: "",
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.bodySmall,
                            color = White
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = item.extraInfo ?: "",
                                textAlign = TextAlign.End,
                                style = MaterialTheme.typography.titleSmall,
                                color = White
                            )
                        }
                        Text(
                            text = stringResource(id = R.string.where).uppercase(),
                            style = MaterialTheme.typography.titleSmall,
                            color = White
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        ShadowBox(
                            elevation = 10.dp,
                            shape = Shapes.small
                        ) {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = Shapes.small,
                                colors = CardDefaults.elevatedCardColors(White.copy(alpha = 0.3f)),
                            ) {
                                Text(
                                    text = stringResource(id = item.address ?: -1).uppercase(),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = White,
                                    modifier = Modifier
                                        .padding(18.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.size(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = stringResource(id = R.string.text_and_photo) + " " + stringResource(
                                    id = item.credits ?: -1
                                ),
                                textAlign = TextAlign.End,
                                style = MaterialTheme.typography.headlineSmall,
                                color = White,
                            )
                        }
                    }
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
                imageId = R.drawable.barcomis_2,
                name = R.string.cafe_1,
                address = R.string.cafe_address_1,
                credits = R.string.credits_cafes_general,
                placeDescription = DataSource.cafes[0].placeDescription,
                extraInfo = DataSource.cafes[0].extraInfo,
                placeDetails = null,
                categoryType = CategoryType.Cafes
            ),
        )
    }
}
