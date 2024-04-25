package com.example.berlin_bucket_list.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.berlin_bucket_list.R
import com.example.berlin_bucket_list.model.BerlinBucketListItem
import com.example.berlin_bucket_list.model.CategoryType
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme
import com.example.berlin_bucket_list.ui.theme.Shapes
import com.example.berlin_bucket_list.ui.utils.ShadowBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerlinBucketListItem(
    item: BerlinBucketListItem,
    onItemClicked: () -> Unit,
    isHomeScreen: Boolean,
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
            colors = CardDefaults.elevatedCardColors(Color.White.copy(alpha = 0.3f)),
            modifier = modifier
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_height))
                        .padding(4.dp)
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
                    style = if (isHomeScreen) {
                        MaterialTheme.typography.displayMedium
                    } else {
                        MaterialTheme.typography.displaySmall
                    },
                    color = Color.White,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )

            }
        }
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
            onItemClicked = {},
            isHomeScreen = true
        )
    }
}