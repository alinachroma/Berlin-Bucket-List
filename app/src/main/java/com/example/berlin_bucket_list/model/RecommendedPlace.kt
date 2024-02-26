package com.example.berlin_bucket_list.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RecommendedPlace(
    @DrawableRes val imageId: Int,
    val placeDescription: String,
    val placeDetails: String = "",
    @StringRes val address: Int,
    @StringRes val credits: Int
)