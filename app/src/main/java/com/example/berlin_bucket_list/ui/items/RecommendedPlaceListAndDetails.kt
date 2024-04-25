package com.example.berlin_bucket_list.ui.items

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.berlin_bucket_list.R
import com.example.berlin_bucket_list.data.DataSource
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.ui.screens.RecommendedPlacesItemList
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme
import com.example.berlin_bucket_list.ui.theme.DarkGreenCard
import com.example.berlin_bucket_list.ui.theme.DarkYellowCard
import com.example.berlin_bucket_list.ui.theme.GreenCard
import com.example.berlin_bucket_list.ui.theme.Shapes
import com.example.berlin_bucket_list.ui.utils.ShadowBox

/** This composable represents a layout for the Expanded screen
 * and landscape orientation.
 * */

val gradientColors = arrayOf(
    0.0f to DarkGreenCard,
    0.5f to GreenCard,
    1f to DarkYellowCard
)

@Composable
fun RecommendedPlaceListAndDetails(
    placesToShow: List<BerlinBucketListItem>,
    onSelectionChanged: (BerlinBucketListItem) -> Unit,
    imageId: Int,
    placeDescription: String,
    extraInfo: String,
    address: Int,
    credits: Int,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        RecommendedPlacesItemList(
            places = placesToShow,
            onSelectionChanged = onSelectionChanged,
            modifier = Modifier.weight(2f)
        )
        Column(
            modifier = Modifier
                .padding(end = 24.dp, bottom = 24.dp)
                .verticalScroll(rememberScrollState())
                .weight(weight = 2f, fill = false)
        ) {
            RecommendedPlaceDetails(
                imageId = imageId,
                placeDescription = placeDescription,
                extraInfo = extraInfo,
                address = address,
                credits = credits,
                windowSize = windowSize,
            )
        }
    }
}

@Composable
fun RecommendedPlaceDetails(
    imageId: Int,
    placeDescription: String,
    extraInfo: String,
    address: Int,
    credits: Int,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy((-100).dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val configuration = LocalConfiguration.current
        val portraitAndCompact = configuration.orientation == ORIENTATION_PORTRAIT
                && windowSize == WindowWidthSizeClass.Compact

        Card(
            modifier = modifier
                .conditional(
                    condition = portraitAndCompact,
                    ifTrue = {
                        shadow(
                            ambientColor = Color.Black,
                            spotColor = Color.Black,
                            elevation = 3.dp,
                            shape = Shapes.medium
                        )
                            .weight(1f)
                    },
                    ifFalse = {
                        shadow(
                            ambientColor = Color.Black,
                            spotColor = Color.Black,
                            elevation = 3.dp,
                            shape = Shapes.medium
                        )
                    }
                )
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .conditional(
                    condition = portraitAndCompact,
                    ifTrue = {
                        shadow(
                            ambientColor = Color.Black,
                            spotColor = Color.Black,
                            elevation = 1.dp,
                            shape = RoundedCornerShape(topStartPercent = 10, topEndPercent = 10)
                        )
                            .background(Brush.verticalGradient(colorStops = gradientColors))
                            .weight(1.2f)

                    },
                    ifFalse = {
                        shadow(
                            ambientColor = Color.Black,
                            spotColor = Color.Black,
                            elevation = 1.dp,
                            shape = RoundedCornerShape(percent = 10)
                        )
                            .background(Brush.verticalGradient(colorStops = gradientColors))
                    }
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                        top = 36.dp,
                        bottom = 24.dp
                    ),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = placeDescription,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = extraInfo,
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White
                    )
                }
                Text(
                    text = stringResource(id = R.string.where).uppercase(),
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White
                )
                Spacer(modifier = Modifier.size(10.dp))
                ShadowBox(
                    elevation = 10.dp,
                    shape = Shapes.small
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = Shapes.small,
                        colors = CardDefaults.elevatedCardColors(
                            Color.White.copy(alpha = 0.3f)
                        ),
                    ) {
                        Text(
                            text = stringResource(id = address).uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White,
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
                            id = credits,
                        ),
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White,
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.ellipse_2),
                alignment = Alignment.BottomStart,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxSize()
                    .alpha(alpha = 0.5f)
            )
        }
    }
}

inline fun Modifier.conditional(
    condition: Boolean,
    ifTrue: Modifier.() -> Modifier,
    ifFalse: Modifier.() -> Modifier = { this },
): Modifier = if (condition) {
    then(ifTrue(Modifier))
} else {
    then(ifFalse(Modifier))
}

@Preview(name = "Dark Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
annotation class ThemePreviews

@ThemePreviews
@Composable
fun PreviewsListItem() {
    BerlinBucketListTheme {
        RecommendedPlaceListAndDetails(
            imageId = R.drawable.tempelhofer_feld,
            placeDescription = DataSource.parks[0].placeDescription!!,
            extraInfo = "",
            address = R.string.park_address_6,
            credits = R.string.credits_park_6,
            onSelectionChanged = {},
            placesToShow = DataSource.parks,
            windowSize = WindowWidthSizeClass.Compact
        )
    }
}


