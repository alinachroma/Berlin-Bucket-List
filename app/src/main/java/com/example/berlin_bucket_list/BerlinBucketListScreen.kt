package com.example.berlin_bucket_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.berlin_bucket_list.data.DataSource
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme
import com.example.berlin_bucket_list.ui.theme.Shapes

@Composable
fun BerlinBucketListApp(
) {
    Scaffold(
        topBar = { BerlinBucketListAppBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
        }
    }
}

@Composable
fun BerlinBucketListItem(
    modifier: Modifier = Modifier,
    imageResourceId: Int,
    stringResourceId: Int
) {
    ElevatedCard {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier.size(dimensionResource(id = R.dimen.icon_height))
            ) {
                Image(
                    painter = painterResource(id = imageResourceId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier.clip(Shapes.small)
                )
            }
            Text(text = stringResource(id = stringResourceId))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerlinBucketListAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.appbar_black),
                contentDescription = null
            )
        },
        modifier = modifier
    )
}


