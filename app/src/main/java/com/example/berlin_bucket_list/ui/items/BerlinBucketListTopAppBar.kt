package com.example.berlin_bucket_list.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.berlin_bucket_list.R
import com.example.berlin_bucket_list.navigation.Screen
import com.example.berlin_bucket_list.ui.theme.BerlinBucketListTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerlinBucketListAppBar(
    screenTitle: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            if (!canNavigateBack) {
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(36.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.bucket_list),
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White
                    )
                }
            } else {
                TopAppBarTitle(title = screenTitle.uppercase())
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button),
                        tint = Color.White
                    )
                }
            }
        },
        modifier = Modifier.padding(top = 20.dp)
    )
}

@Composable
fun TopAppBarTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelMedium,
        color = Color.White,
        modifier = modifier
    )
}

@Composable
fun AppLogoBig(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.appbar_white),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = modifier.offset(y = 4.dp)
    )
    Image(
        painter = painterResource(id = R.drawable.appbar_black),
        contentDescription = null,
        contentScale = ContentScale.Fit,
    )
}

@Preview(showBackground = true)
@Composable
fun BerlinBucketListAppBarPreview() {
    BerlinBucketListTheme {
        BerlinBucketListAppBar(
            canNavigateBack = false,
            screenTitle = Screen.HomeScreen.route
        )
    }
}
