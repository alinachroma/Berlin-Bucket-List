package com.example.berlin_bucket_list.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BerlinBucketListItem(
    @DrawableRes val imageId: Int,
    @StringRes val name: Int,
    @StringRes val address: Int? = null,
    @StringRes val credits: Int? = null,
    val placeDescription: String? = "",
    val placeDetails: String? = "",
    val extraInfo: String? = "",
    val categoryType: CategoryType,
)